package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "APIs related to product operations")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    @Operation(summary = "Create Product", description = "Create a new product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/getProduct/{id}")
    @Operation(summary = "Get Product", description = "Retrieve a product by ID")
    public Product getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct/{id}")
    @Operation(summary = "Update Product", description = "Update an existing product")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    @Operation(summary = "Delete Product", description = "Delete a product by ID")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/getAllProducts")
    @Operation(summary = "Get All Products", description = "Retrieve all products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
