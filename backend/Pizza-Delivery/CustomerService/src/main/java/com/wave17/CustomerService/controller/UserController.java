package com.wave17.CustomerService.controller;

import com.wave17.CustomerService.domain.User;
import com.wave17.CustomerService.exception.UserAlreadyExistsException;
import com.wave17.CustomerService.exception.UserNotFoundException;
import com.wave17.CustomerService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    private UserService userService;
    private ResponseEntity responseEntity;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        User userSave = userService.saveUser(user);
        return responseEntity = new ResponseEntity<>("User Created !!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {
        try {
            User userObj = userService.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
            if (userObj.getEmailId().equals(user.getEmailId())) {
                responseEntity = new ResponseEntity<>("found", HttpStatus.OK);
            }
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();

        } catch (Exception e) {
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/api/v1/user-service/users")
    public ResponseEntity getAllUsers(){

        List<User> list =  userService.getAllUsers();
        responseEntity = new ResponseEntity(list,HttpStatus.OK);
        return responseEntity;
    }
}
