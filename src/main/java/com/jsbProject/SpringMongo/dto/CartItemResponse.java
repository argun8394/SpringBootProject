package com.jsbProject.SpringMongo.dto;

import lombok.Data;

@Data
public class CartItemResponse {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
}
