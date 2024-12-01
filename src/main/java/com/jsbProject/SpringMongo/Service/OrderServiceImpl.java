package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.Repository.CartRepository;
import com.jsbProject.SpringMongo.Repository.OrderRepository;
import com.jsbProject.SpringMongo.dto.OrderRequest;
import com.jsbProject.SpringMongo.dto.OrderResponse;
import com.jsbProject.SpringMongo.entity.Cart;
import com.jsbProject.SpringMongo.entity.Order;
import com.jsbProject.SpringMongo.entity.OrderItem;
import com.jsbProject.SpringMongo.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        Cart cart = cartRepository.findByCustomerId(request.getCustomerId());
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty or not found for customer");
        }

        Order order = new Order();
        order.setCustomerId(cart.getCustomerId());
        order.setTotalPrice(cart.getTotalPrice());
        order.setItems(cart.getItems().stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(item.getProductId());
            orderItem.setProductName(item.getProductName());
            orderItem.setPriceAtOrderTime(item.getPrice());
            orderItem.setQuantity(item.getQuantity());
            return orderItem;
        }).collect(Collectors.toList()));
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);

        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse getOrderForCode(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrdersForCustomer(String customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }
}