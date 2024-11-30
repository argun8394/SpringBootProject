package com.jsbProject.SpringMongo.Controller;

import com.jsbProject.SpringMongo.Model.Product;
import com.jsbProject.SpringMongo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

@Autowired
ProductRepo productRepo;
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productRepo.save(product);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productRepo.findById(id).orElse(null);
    }

    @GetMapping("/fetchProducts")
    public List<Product> fetchProducts(){
        return productRepo.findAll();
    }

    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        Product data=productRepo.findById(product.getPno()).orElse(null);
        System.out.println(data);

        //check if null
        if(data!=null)
        {
            data.setName(product.getName());
            data.setPrice(product.getPrice());
            data.setQuantity(product.getQuantity());
            productRepo.save(data);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productRepo.deleteById(id);
    }

}
