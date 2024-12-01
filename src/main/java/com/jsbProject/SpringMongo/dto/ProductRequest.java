package com.jsbProject.SpringMongo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private double price;
    private int stock;

}