package com.wave17.ProductService.service;

import com.wave17.ProductService.domain.Cart;
import com.wave17.ProductService.domain.Pizza;
import com.wave17.ProductService.exception.CartAlreadyExistsException;
import com.wave17.ProductService.exception.CartNotFoundException;
import com.wave17.ProductService.exception.ProductNotFoundException;

import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart) throws CartAlreadyExistsException;
    List<Cart> getAllCarts() throws Exception;
    Cart findByUserId(int userId) throws CartNotFoundException;
    List<Cart> getAllCartsByUserId(int userId) throws CartNotFoundException;
    boolean deletePizza(int pizzaId) throws ProductNotFoundException, CartNotFoundException;
}
