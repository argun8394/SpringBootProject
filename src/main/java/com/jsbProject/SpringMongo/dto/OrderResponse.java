package com.jsbProject.SpringMongo.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private String id;
    private String customerId;
    private List<OrderItemResponse> items;
    private double totalPrice;
}

