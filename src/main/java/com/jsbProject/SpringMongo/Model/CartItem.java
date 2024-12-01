package com.jsbProject.SpringMongo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Integer productId;
    private String productName;
    private Integer price;
    private Integer quantity;
}
