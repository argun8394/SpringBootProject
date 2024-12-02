package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;
    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    @Transactional
    public Order placeOrder(String customerId) {
        Cart cart = cartService.getCartByCustomerId(customerId);

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        List<OrderItem> orderItems = cart.getItems().stream()
                .map(cartItem -> {
                    Product product = productService.getProductById(cartItem.getProductId());
                    if (product.getStock() < cartItem.getQuantity()) {
                        throw new RuntimeException("Insufficient stock for product: " + product.getName());
                    }
                    product.setStock(product.getStock() - cartItem.getQuantity());
                    productService.updateProduct(product.getId(), product);
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(cartItem.getProductId());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItem.setPrice(cartItem.getPrice());
                    return orderItem;
                })
                .collect(Collectors.toList());

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setItems(orderItems);
        order.setTotalPrice(cart.getTotalPrice());
        order.setOrderCode(UUID.randomUUID().toString());

        Order savedOrder = orderRepository.save(order);
        cartService.emptyCart(customerId);

        return savedOrder;
    }

    @Override
    public Order getOrderByCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }

    @Override
    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }
}
