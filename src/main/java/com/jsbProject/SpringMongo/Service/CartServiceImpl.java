package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.Repository.CartRepository;
import com.jsbProject.SpringMongo.Repository.ProductRepository;
import com.jsbProject.SpringMongo.dto.CartRequest;
import com.jsbProject.SpringMongo.dto.CartResponse;
import com.jsbProject.SpringMongo.entity.Cart;
import com.jsbProject.SpringMongo.entity.CartItem;
import com.jsbProject.SpringMongo.entity.Product;
import com.jsbProject.SpringMongo.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponse getCart(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            cart = new Cart();
            cart.setCustomerId(customerId);
            cart.setTotalPrice(0.0);
            cartRepository.save(cart);
        }
        return cartMapper.toResponse(cart);
    }

    @Override
    public CartResponse addProductToCart(CartRequest request) {
        Cart cart = cartRepository.findByCustomerId(request.getCustomerId());
        if (cart == null) {
            cart = new Cart();
            cart.setCustomerId(request.getCustomerId());
        }
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        boolean productExists = false;
        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + request.getQuantity());
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            CartItem newItem = new CartItem();
            newItem.setProductId(product.getId());
            newItem.setProductName(product.getName());
            newItem.setPrice(product.getPrice());
            newItem.setQuantity(request.getQuantity());
            cart.getItems().add(newItem);
        }

        cart.setTotalPrice(cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum());

        product.setStock(product.getStock() - request.getQuantity());
        productRepository.save(product);

        return cartMapper.toResponse(cartRepository.save(cart));
    }
    @Override
    public CartResponse removeProductFromCart(CartRequest request) {
        Cart cart = cartRepository.findByCustomerId(request.getCustomerId());
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer");
        }

        CartItem itemToRemove = null;
        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(request.getProductId())) {
                if (item.getQuantity() <= request.getQuantity()) {
                    itemToRemove = item;
                } else {
                    item.setQuantity(item.getQuantity() - request.getQuantity());
                }
                break;
            }
        }

        if (itemToRemove != null) {
            cart.getItems().remove(itemToRemove);
        }

        cart.setTotalPrice(cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum());

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(product.getStock() + request.getQuantity());
        productRepository.save(product);

        return cartMapper.toResponse(cartRepository.save(cart));
    }
    @Override
    public CartResponse emptyCart(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer");
        }

        for (CartItem item : cart.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            product.setStock(product.getStock() + item.getQuantity());
            productRepository.save(product);
        }

        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        return cartMapper.toResponse(cartRepository.save(cart));
    }
}