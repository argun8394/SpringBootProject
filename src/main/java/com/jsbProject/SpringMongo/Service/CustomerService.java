package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.dto.CustomerRequest;
import com.jsbProject.SpringMongo.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponse addCustomer(CustomerRequest request);
    CustomerResponse getCustomer(String id);
    List<CustomerResponse> getAllCustomers();
}
