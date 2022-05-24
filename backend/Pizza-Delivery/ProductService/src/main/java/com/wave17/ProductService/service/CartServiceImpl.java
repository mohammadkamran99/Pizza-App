package com.wave17.ProductService.service;

import com.wave17.ProductService.domain.Cart;
import com.wave17.ProductService.exception.CartAlreadyExistsException;
import com.wave17.ProductService.exception.CartNotFoundException;
import com.wave17.ProductService.exception.ProductNotFoundException;
import com.wave17.ProductService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart saveCart(Cart cart) throws CartAlreadyExistsException {
//        if (cartRepository.findById(cart.getCartId()).isPresent()) {
//            throw new CartAlreadyExistsException();
//        }
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() throws Exception {
        if (cartRepository.findAll().isEmpty()) {
            throw new Exception();
        }
        return cartRepository.findAll();
    }

//    public List<Cart> getAllCartsByUserId(int userId) throws Exception {
//        if (cartRepository.findCartsByUserId(userId).isEmpty()) {
//            throw new Exception();
//        }
//        return cartRepository.findAll();
//    }

    @Override
    public Cart findByUserId(int userId) throws CartNotFoundException {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        return cart;
    }

    @Override
    public List<Cart> getAllCartsByUserId(int userId) throws CartNotFoundException {
//        if(customerRepository.findAllCustomerFromCity(city).isEmpty())
//        {
//            throw new CustomerNotFoundException();
//        }
        return cartRepository.findAllCartsByUserId(userId);
        // return null;
    }

    @Override
    public boolean deletePizza(int pizzaId) throws ProductNotFoundException {
        System.out.println("ssssssssssssssssssssssss");
        boolean flag = false;
//        if (cartRepository.findByPizzaId(pizzaId).isEmpty()) {
//            System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn");
//            throw new ProductNotFoundException();
//        } else
        {
            System.out.println("ddddddddddddddddddddddddddddddddddd");
            cartRepository.deleteByPizzaId(pizzaId);
            flag = true;
        }
        return flag;
    }


}
