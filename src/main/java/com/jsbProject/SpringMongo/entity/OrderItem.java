package com.jsbProject.SpringMongo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private String productId;
    private String productName;
    private double priceAtOrderTime;
    private int quantity;
}