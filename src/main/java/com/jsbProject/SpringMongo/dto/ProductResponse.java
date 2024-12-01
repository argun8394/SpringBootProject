package com.jsbProject.SpringMongo.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private double price;
    private int stock;
}