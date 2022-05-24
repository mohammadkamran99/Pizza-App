package com.wave17.ProductService.repository;

import com.wave17.ProductService.domain.Cart;
import com.wave17.ProductService.exception.CartNotFoundException;
import com.wave17.ProductService.exception.ProductNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart,Integer> {
    Cart findByUserId(int userId) throws CartNotFoundException;
    void deleteByPizzaId(int pizzaId)  throws ProductNotFoundException;
//    @Query("{'customerAddress.city' : {$in : [?0]}}")
    List<Cart> findAllCartsByUserId(int userId);
}
