package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order Controller", description = "APIs related to order operations")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/placeOrder/{customerId}")
    @Operation(summary = "Place Order", description = "Place an order for a customer")
    public Order placeOrder(@PathVariable String customerId) {
        return orderService.placeOrder(customerId);
    }

    @GetMapping("/getOrderForCode/{orderCode}")
    @Operation(summary = "Get Order by Code", description = "Retrieve an order by its code")
    public Order getOrderByCode(@PathVariable String orderCode) {
        return orderService.getOrderByCode(orderCode);
    }

    @GetMapping("/getAllOrdersForCustomer/{customerId}")
    @Operation(summary = "Get All Orders for Customer", description = "Retrieve all orders for a customer")
    public List<Order> getAllOrdersForCustomer(@PathVariable String customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }
}
