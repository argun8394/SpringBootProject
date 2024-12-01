package com.jsbProject.SpringMongo.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private String id;
    private String name;
    private String email;
}