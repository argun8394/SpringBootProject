package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.dto.ProductRequest;
import com.jsbProject.SpringMongo.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
    ProductResponse getProduct(String id);
    List<ProductResponse> getAllProducts();
}
