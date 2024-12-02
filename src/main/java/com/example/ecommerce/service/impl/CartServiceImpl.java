package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    @Override
    public Cart getCartByCustomerId(String customerId) {
        return Optional.ofNullable(cartRepository.findByCustomerId(customerId))
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setCustomerId(customerId);
                    cart.setItems(new ArrayList<>());
                    cart.setTotalPrice(0.0);
                    return cartRepository.save(cart);
                });
    }

    @Override
    public Cart addProductToCart(String customerId, String productId, int quantity) {
        Cart cart = getCartByCustomerId(customerId);
        Product product = productService.getProductById(productId);

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + product.getName());
        }

        List<CartItem> items = cart.getItems();
        Optional<CartItem> existingItemOpt = items.stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        if (existingItemOpt.isPresent()) {
            CartItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setPrice(product.getPrice());
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(productId);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(product.getPrice());
            items.add(cartItem);
        }

        recalculateCartTotalPrice(cart);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeProductFromCart(String customerId, String productId) {
        Cart cart = getCartByCustomerId(customerId);
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        recalculateCartTotalPrice(cart);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(String customerId, Cart cart) {
        Cart existingCart = getCartByCustomerId(customerId);
        existingCart.setItems(cart.getItems());
        recalculateCartTotalPrice(existingCart);
        return cartRepository.save(existingCart);
    }

    @Override
    public void emptyCart(String customerId) {
        Cart cart = getCartByCustomerId(customerId);
        cart.setItems(new ArrayList<>());
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }

    private void recalculateCartTotalPrice(Cart cart) {
        double totalPrice = cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
    }
}
