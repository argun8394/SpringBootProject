package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.dto.CustomerRequest;
import com.jsbProject.SpringMongo.dto.CustomerResponse;
import com.jsbProject.SpringMongo.entity.Customer;
import com.jsbProject.SpringMongo.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jsbProject.SpringMongo.Repository.;import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse addCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse getCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toResponse).collect(Collectors.toList());
    }
}
