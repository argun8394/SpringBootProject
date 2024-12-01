package com.jsbProject.SpringMongo.Controller;

import com.jsbProject.SpringMongo.Service.ProductService;
import com.jsbProject.SpringMongo.Service.ProductServiceImpl;
import com.jsbProject.SpringMongo.dto.ProductRequest;
import com.jsbProject.SpringMongo.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productServiceImpl.createProduct(request);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
        return productServiceImpl.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productServiceImpl.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id) {
        return productServiceImpl.getProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }
}
