package com.jsbProject.SpringMongo.Controller;

import com.jsbProject.SpringMongo.Service.CartService;
import com.jsbProject.SpringMongo.dto.CartRequest;
import com.jsbProject.SpringMongo.dto.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{customerId}")
    public CartResponse getCart(@PathVariable String customerId) {
        return cartService.getCart(customerId);
    }

    @PostMapping("/add")
    public CartResponse addProductToCart(@RequestBody CartRequest request) {
        return cartService.addProductToCart(request);
    }

    @PostMapping("/remove")
    public CartResponse removeProductFromCart(@RequestBody CartRequest request) {
        return cartService.removeProductFromCart(request);
    }

    @DeleteMapping("/{customerId}")
    public CartResponse emptyCart(@PathVariable String customerId) {
        return cartService.emptyCart(customerId);
    }
}
