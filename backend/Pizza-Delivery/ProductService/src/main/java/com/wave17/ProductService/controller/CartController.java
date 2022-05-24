package com.wave17.ProductService.controller;

import com.wave17.ProductService.domain.Cart;
import com.wave17.ProductService.exception.CartAlreadyExistsException;
import com.wave17.ProductService.exception.CartNotFoundException;
import com.wave17.ProductService.exception.ProductNotFoundException;
import com.wave17.ProductService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/cart-service/")
//@CrossOrigin(origins = "*")
public class CartController {
    private ResponseEntity responseEntity;
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("add-cart")
    public ResponseEntity<?> saveCart(@RequestBody Cart cart) throws CartAlreadyExistsException {
        System.out.println("---------------------------------------**********------------------------------------------");
        try {
            cartService.saveCart(cart);
            System.out.println(cart);
            responseEntity = new ResponseEntity(cart, HttpStatus.CREATED);
        } catch (CartAlreadyExistsException e) {
            throw new CartAlreadyExistsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

//    @CrossOrigin("http://localhost:4200")
    @GetMapping("/carts")
    public ResponseEntity<?> getAllCarts() throws Exception {
        try {
            responseEntity = new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !! Try somtime", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }

//    @CrossOrigin("http://localhost:4200")
    @PostMapping("/user-id")
    public ResponseEntity cartByUserId(@RequestBody Cart cart) throws CartNotFoundException {
        try {
            Cart cartObj = cartService.findByUserId(cart.getUserId());
            if (cartObj.getUserId() == cart.getUserId()) {
                responseEntity = new ResponseEntity<>("found", HttpStatus.OK);
            }
        } catch (CartNotFoundException e) {
            throw new CartNotFoundException();

        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("carts/{userId}")
    public ResponseEntity<?> getAllCartByUserId(@PathVariable int userId){
        try{
            responseEntity = new ResponseEntity(cartService.getAllCartsByUserId(userId), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

//    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("pizza/{pizzaId}")
    public ResponseEntity<?> deletePizza(@PathVariable("pizzaId") int pizzaId) throws ProductNotFoundException {
        System.out.println("-------------------------------------------------------------------");
        System.out.println(pizzaId);
        try {
            cartService.deletePizza(pizzaId);
            responseEntity = new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            System.out.println("00000000000000000000000000000000000000000000000");
            throw new ProductNotFoundException();
        }
        catch (Exception exception){
            System.out.println("7777777777777777777777777777777777777777");
            String ex = exception.getMessage();
            System.out.println(exception.getMessage());
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

//    accept the user id and return object and applied on your
//    find by user id  in service clss

