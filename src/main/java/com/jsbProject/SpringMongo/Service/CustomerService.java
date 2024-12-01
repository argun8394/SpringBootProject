package com.jsbProject.SpringMongo.Service;

import com.jsbProject.SpringMongo.Model.*;
import com.jsbProject.SpringMongo.Repository.CustomerRepo;
import com.jsbProject.SpringMongo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    public void addCustomer(Customer customer) {
        customer.setCart(new Cart());
        customerRepo.save(customer);
    }

    public Cart getCart(Integer customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        return customer != null ? customer.getCart() : null;
    }

    public void addProductToCart(Integer customerId, Integer productId, Integer quantity) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        Product product = productRepo.findById(productId).orElse(null);

        if (customer == null || product == null || product.getQuantity() < quantity) {
            throw new RuntimeException("Invalid operation");
        }

        Cart cart = customer.getCart();
        cart.setTotalPrice(cart.getTotalPrice() == null ? 0 : cart.getTotalPrice());

        boolean updated = false;

        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                updated = true;
                break;
            }
        }

        if (!updated) {
            cart.getItems().add(new CartItem(productId, product.getName(), product.getPrice(), quantity));
        }

        cart.setTotalPrice(cart.getItems().stream()
                .mapToInt(i -> i.getPrice() * i.getQuantity())
                .sum());

        product.setQuantity(product.getQuantity() - quantity);
        productRepo.save(product);

        customerRepo.save(customer);
    }

    public void placeOrder(Integer customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        Cart cart = customer.getCart();
        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                cart.getItems(),
                cart.getTotalPrice()
        );

        customer.getOrders().add(order);
        customer.setCart(new Cart()); // Empty cart
        customerRepo.save(customer);
    }
}
