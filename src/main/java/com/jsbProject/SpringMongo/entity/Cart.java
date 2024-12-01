package com.jsbProject.SpringMongo.entity;

import com.jsbProject.SpringMongo.entity.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "carts")
public class Cart extends BaseEntity {
    private String customerId;
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;
}


