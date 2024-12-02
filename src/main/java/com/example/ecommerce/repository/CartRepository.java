package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByCustomerId(String customerId);
}
