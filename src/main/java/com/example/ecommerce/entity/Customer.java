package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "customers")
@Schema(description = "Entity representing a customer")
public class Customer extends BaseEntity {

    @Schema(description = "Name of the customer", example = "John Doe")
    private String name;

    @Schema(description = "Email address of the customer", example = "john.doe@example.com")
    private String email;
}
