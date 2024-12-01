package com.jsbProject.SpringMongo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderCode;
    private List<CartItem> items;
    private Integer totalPrice;
}

