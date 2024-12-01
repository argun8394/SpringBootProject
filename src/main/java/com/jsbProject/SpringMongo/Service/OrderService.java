package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.dto.OrderRequest;
import com.jsbProject.SpringMongo.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);

    OrderResponse placeOrder(OrderRequest request);

    OrderResponse getOrderForCode(String orderId);
    List<OrderResponse> getAllOrdersForCustomer(String customerId);
}
