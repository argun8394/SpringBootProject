package com.jsbProject.SpringMongo.Repository;

import com.jsbProject.SpringMongo.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {
}

