package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderCode(String orderCode);
    List<Order> findAllByCustomerId(String customerId);
}
