package com.example.CartApplication;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/store/order")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public String addToCard(@RequestParam(value = "itemIds") Long[] itemId, HttpSession session){
        cartService.addItem(session, Arrays.asList(itemId));
        return "Успешно добавлено";
    }

    @GetMapping
    public List<CartItem> getCart(HttpSession session){
        return cartService.getItems(session);
    }

}
