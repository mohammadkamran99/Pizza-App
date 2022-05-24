package com.wave17.ProductService.service;

import com.wave17.ProductService.domain.Pizza;
import com.wave17.ProductService.exception.ProductAlreadyExistsException;
import com.wave17.ProductService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Pizza saveProduct(Pizza pizza) throws ProductAlreadyExistsException;

    List<Pizza> getAllProducts() throws Exception;

    boolean deleteProduct(int pizzaId) throws ProductNotFoundException;

}
