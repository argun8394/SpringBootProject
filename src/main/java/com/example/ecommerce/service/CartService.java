package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;

public interface CartService {
    Cart getCartByCustomerId(String customerId);
    Cart addProductToCart(String customerId, String productId, int quantity);
    Cart removeProductFromCart(String customerId, String productId);
    Cart updateCart(String customerId, Cart cart);
    void emptyCart(String customerId);
}
