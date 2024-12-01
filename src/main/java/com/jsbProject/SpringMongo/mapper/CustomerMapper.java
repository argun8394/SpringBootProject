package com.jsbProject.SpringMongo.mapper;

import com.jsbProject.SpringMongo.dto.CustomerRequest;
import com.jsbProject.SpringMongo.dto.CustomerResponse;
import com.jsbProject.SpringMongo.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest request);
    CustomerResponse toResponse(Customer customer);
}
