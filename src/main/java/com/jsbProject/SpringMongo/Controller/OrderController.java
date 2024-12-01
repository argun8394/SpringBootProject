package com.jsbProject.SpringMongo.Controller;

import com.jsbProject.SpringMongo.dto.OrderRequest;
import com.jsbProject.SpringMongo.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest request) {
        return orderServiceImpl.placeOrder(request);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderForCode(@PathVariable String orderId) {
        return orderServiceImpl.getOrderForCode(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderResponse> getAllOrdersForCustomer(@PathVariable String customerId) {
        return orderServiceImpl.getAllOrdersForCustomer(customerId);
    }
}
