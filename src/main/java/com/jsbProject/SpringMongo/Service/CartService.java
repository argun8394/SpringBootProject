package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.dto.CartRequest;
import com.jsbProject.SpringMongo.dto.CartResponse;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    CartResponse getCart(String customerId);
    CartResponse addProductToCart(CartRequest request);
    CartResponse removeProductFromCart(CartRequest request);

    CartResponse removeProductFromCart(CartRequest request);

    CartResponse emptyCart(String customerId);
}
