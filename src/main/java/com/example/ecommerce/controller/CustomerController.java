package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Customer Controller", description = "APIs related to customer operations")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    @Operation(summary = "Add Customer", description = "Add a new customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/getCustomer/{id}")
    @Operation(summary = "Get Customer", description = "Retrieve a customer by ID")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }
}
