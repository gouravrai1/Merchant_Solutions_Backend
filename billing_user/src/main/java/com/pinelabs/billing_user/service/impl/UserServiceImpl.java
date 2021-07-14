package com.pinelabs.billing_user.service.impl;

import com.pinelabs.billing_user.model.User;
import com.pinelabs.billing_user.repository.UserRepository;
import com.pinelabs.billing_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserName(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
}
