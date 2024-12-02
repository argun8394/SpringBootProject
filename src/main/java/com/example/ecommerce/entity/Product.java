package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "products")
@Schema(description = "Entity representing a product")
public class Product extends BaseEntity {

    @Schema(description = "Name of the product", example = "Wireless Headphones")
    private String name;

    @Schema(description = "Price of the product", example = "99.99")
    private Double price;

    @Schema(description = "Available stock of the product", example = "50")
    private Integer stock;
}
