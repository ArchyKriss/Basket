package com.example.CartApplication;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static final String CART_SESSION_KEY = "cart";

    public void addItem(HttpSession session, List<Long> itemIds){
        List<CartItem> cart = (List<CartItem>) session.getAttribute(CART_SESSION_KEY);
        if(cart==null){
            cart = new ArrayList<>();
            session.getAttribute(CART_SESSION_KEY);
        }
        for(Long itemId : itemIds){
            cart.add(new CartItem(itemId));
        }
        session.setAttribute(CART_SESSION_KEY, cart);
    }
    public List<CartItem> getItems(HttpSession session){
        List<CartItem> cart = (List<CartItem>) session.getAttribute(CART_SESSION_KEY);
        return cart != null ? cart : new ArrayList<>();
    }
}
