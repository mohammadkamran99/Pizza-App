package com.wave17.ProductService.controller;

import com.wave17.ProductService.domain.Pizza;
import com.wave17.ProductService.exception.ProductAlreadyExistsException;
import com.wave17.ProductService.exception.ProductNotFoundException;
import com.wave17.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product-service/")
@CrossOrigin(origins = "*")
public class ProductController {
    private ResponseEntity responseEntity;
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addproduct")
    public ResponseEntity<?> saveProduct(@RequestBody Pizza pizza) throws ProductAlreadyExistsException {
        try {
            productService.saveProduct(pizza);
            responseEntity = new ResponseEntity(pizza, HttpStatus.CREATED);
        } catch (ProductAlreadyExistsException e) {
            throw new ProductAlreadyExistsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() throws Exception {
        try {
            responseEntity = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !! Try somtime", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }

    @DeleteMapping("/product/{pizzaId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("pizzaId") int pizzaId) throws ProductNotFoundException {
        try{
            productService.deleteProduct(pizzaId);
            responseEntity = new ResponseEntity<>("Successfully deleted !!!", HttpStatus.OK);
        }
        catch(ProductNotFoundException e)
        {
            throw  new ProductNotFoundException();
        }
        catch(Exception exception)
        {
            String ex = exception.getMessage();
            System.out.println(exception.getMessage());
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
