package com.jsbProject.SpringMongo.dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private String productId;
    private String productName;
    private double priceAtOrderTime;
    private int quantity;
}