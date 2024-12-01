package com.jsbProject.SpringMongo.mapper;

import com.jsbProject.SpringMongo.dto.OrderResponse;
import com.jsbProject.SpringMongo.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toResponse(Order order);
}
