package com.wave17.CustomerService.service;

import com.wave17.CustomerService.domain.User;
import com.wave17.CustomerService.exception.UserAlreadyExistsException;
import com.wave17.CustomerService.exception.UserNotFoundException;
import com.wave17.CustomerService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getUserId()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmailIdAndPassword(String emailId, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailIdAndPassword(emailId, password);
        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
