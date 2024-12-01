package com.jsbProject.SpringMongo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Integer id;

    private String name;
    private String email;

    private Cart cart;

    private List<Order> orders;
}

