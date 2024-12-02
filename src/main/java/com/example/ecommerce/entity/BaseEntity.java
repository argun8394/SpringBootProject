package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Schema(description = "Base entity class containing common properties")
public abstract class BaseEntity {

    @Id
    @Schema(description = "Unique identifier of the entity", example = "60d0fe4f5311236168a109ca")
    private String id;

    @CreatedDate
    @Field("created_date")
    @Schema(description = "Timestamp when the entity was created", example = "2023-10-12T10:15:30")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Field("modified_date")
    @Schema(description = "Timestamp when the entity was last modified", example = "2023-10-13T11:20:45")
    private LocalDateTime modifiedDate;
}
