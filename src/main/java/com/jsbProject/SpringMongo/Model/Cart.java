package com.jsbProject.SpringMongo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Integer customerId;
    private List<CartItem> items = new ArrayList<>();
    private Integer totalPrice = 0;
}
