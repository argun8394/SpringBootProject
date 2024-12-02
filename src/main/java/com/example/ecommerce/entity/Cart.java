package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "carts")
@Schema(description = "Entity representing a customer's shopping cart")
public class Cart extends BaseEntity {

    @Schema(description = "Identifier of the customer owning the cart", example = "60d0fe4f5311236168a109cb")
    private String customerId;

    @Schema(description = "List of items in the cart")
    private List<CartItem> items;

    @Schema(description = "Total price of all items in the cart", example = "199.99")
    private Double totalPrice;
}
