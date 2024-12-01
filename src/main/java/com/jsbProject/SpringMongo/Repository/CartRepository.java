package com.jsbProject.SpringMongo.Repository;

import com.jsbProject.SpringMongo.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByCustomerId(String customerId);
}
