package com.pinelabs.billing_user.service;

import com.pinelabs.billing_user.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserName(Long id);

    User addUser(User user);

}
