package com.jsbProject.SpringMongo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponse {
    private String id;
    private String customerId;
    private List<CartItemResponse> items;
    private double totalPrice;
}

