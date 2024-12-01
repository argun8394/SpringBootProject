package com.jsbProject.SpringMongo.Controller;

import com.jsbProject.SpringMongo.Model.Cart;
import com.jsbProject.SpringMongo.Model.Customer;
import com.jsbProject.SpringMongo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping("/{id}/cart")
    public Cart getCart(@PathVariable Integer id) {
        return customerService.getCart(id);
    }

    @PostMapping("/{customerId}/cart/add/{productId}")
    public void addProductToCart(@PathVariable Integer customerId, @PathVariable Integer productId, @RequestParam Integer quantity) {
        customerService.addProductToCart(customerId, productId, quantity);
    }

    @PostMapping("/{customerId}/order/place")
    public void placeOrder(@PathVariable Integer customerId) {
        customerService.placeOrder(customerId);
    }
}

