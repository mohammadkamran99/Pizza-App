package com.wave17.CustomerService.service;

import com.wave17.CustomerService.domain.User;
import com.wave17.CustomerService.exception.UserAlreadyExistsException;
import com.wave17.CustomerService.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User findByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException;
    List<User> getAllUsers();
}
