package com.wave17.ProductService.service;

import com.wave17.ProductService.domain.Pizza;
import com.wave17.ProductService.exception.ProductAlreadyExistsException;
import com.wave17.ProductService.exception.ProductNotFoundException;
import com.wave17.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Pizza saveProduct(Pizza pizza) throws ProductAlreadyExistsException {
        if (productRepository.findById(pizza.getPizzaId()).isPresent()) {
            throw new ProductAlreadyExistsException();
        }
        return productRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllProducts() throws Exception {
        if (productRepository.findAll().isEmpty()) {
            throw new Exception();
        }
        return productRepository.findAll();
    }
    @Override
    public boolean deleteProduct(int pizzaId) throws ProductNotFoundException {

        boolean flag = false;
        if(productRepository.findById(pizzaId).isEmpty())
        {
            throw new ProductNotFoundException();
        }
        else
        {
            productRepository.deleteById(pizzaId);
            flag=true;
        }
        return flag;
    }
}
