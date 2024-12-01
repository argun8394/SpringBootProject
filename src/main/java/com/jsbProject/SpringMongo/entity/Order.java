package com.jsbProject.SpringMongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "orders")
public class Order extends BaseEntity {
    private String customerId;
    private List<OrderItem> items;
    private double totalPrice;
}


