package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "orders")
@Schema(description = "Entity representing an order")
public class Order extends BaseEntity {

    @Schema(description = "Identifier of the customer who placed the order", example = "60d0fe4f5311236168a109cb")
    private String customerId;

    @Schema(description = "Unique code of the order", example = "ORD123456")
    private String orderCode;

    @Schema(description = "List of items in the order")
    private List<OrderItem> items;

    @Schema(description = "Total price of the order", example = "199.99")
    private Double totalPrice;
}
