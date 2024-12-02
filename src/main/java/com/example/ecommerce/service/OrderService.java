package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String customerId);
    Order getOrderByCode(String orderCode);
    List<Order> getOrdersByCustomerId(String customerId);
}
