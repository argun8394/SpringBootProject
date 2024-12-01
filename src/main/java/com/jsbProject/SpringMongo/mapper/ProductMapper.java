package com.jsbProject.SpringMongo.mapper;

import com.jsbProject.SpringMongo.dto.ProductRequest;
import com.jsbProject.SpringMongo.dto.ProductResponse;
import com.jsbProject.SpringMongo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequest request);
    ProductResponse toResponse(Product product);
}
