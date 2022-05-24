package com.wave17.ProductService.repository;

import com.wave17.ProductService.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Pizza,Integer> {
}
