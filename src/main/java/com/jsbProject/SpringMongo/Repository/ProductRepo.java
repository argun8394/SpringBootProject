package com.jsbProject.SpringMongo.Repository;

import com.jsbProject.SpringMongo.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, Integer> {
}
