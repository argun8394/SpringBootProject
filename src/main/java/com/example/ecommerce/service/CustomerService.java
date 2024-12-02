package com.example.ecommerce.service;

import com.example.ecommerce.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerById(String id);
}
