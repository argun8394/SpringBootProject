package com.jsbProject.SpringMongo.mapper;

import com.jsbProject.SpringMongo.dto.CartResponse;
import com.jsbProject.SpringMongo.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper Instance=Mappers.getMapper(CartMapper.class);
    CartResponse toResponse(Cart cart);
}