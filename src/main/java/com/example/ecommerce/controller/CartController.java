package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@Tag(name = "Cart Controller", description = "APIs related to cart operations")
public class CartController {

    private final CartService cartService;

    @GetMapping("/getCart/{customerId}")
    @Operation(summary = "Get Cart", description = "Retrieve the cart of a customer by customer ID")
    public Cart getCart(@PathVariable String customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @PutMapping("/updateCart/{customerId}")
    @Operation(summary = "Update Cart", description = "Update the cart of a customer")
    public Cart updateCart(@PathVariable String customerId, @RequestBody Cart cart) {
        return cartService.updateCart(customerId, cart);
    }

    @DeleteMapping("/emptyCart/{customerId}")
    @Operation(summary = "Empty Cart", description = "Empty the cart of a customer")
    public void emptyCart(@PathVariable String customerId) {
        cartService.emptyCart(customerId);
    }

    @PostMapping("/addProductToCart/{customerId}")
    @Operation(summary = "Add Product to Cart", description = "Add a product to the customer's cart")
    public Cart addProductToCart(@PathVariable String customerId,
                                 @RequestParam String productId,
                                 @RequestParam int quantity) {
        return cartService.addProductToCart(customerId, productId, quantity);
    }

    @PostMapping("/removeProductFromCart/{customerId}")
    @Operation(summary = "Remove Product from Cart", description = "Remove a product from the customer's cart")
    public Cart removeProductFromCart(@PathVariable String customerId,
                                      @RequestParam String productId) {
        return cartService.removeProductFromCart(customerId, productId);
    }
}
