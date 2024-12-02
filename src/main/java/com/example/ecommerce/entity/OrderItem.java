package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Entity representing an item in an order")
public class OrderItem {

    @Schema(description = "Identifier of the product", example = "60d0fe4f5311236168a109cc")
    private String productId;

    @Schema(description = "Quantity of the product ordered", example = "2")
    private Integer quantity;

    @Schema(description = "Price of the product at the time of ordering", example = "99.99")
    private Double price;
}
