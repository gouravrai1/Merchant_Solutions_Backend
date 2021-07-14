package com.pinelabs.billing_user.api;

import com.pinelabs.billing_user.model.User;
import com.pinelabs.billing_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Optional<User> getStoreName(@PathVariable("userId") Long userId) {
        Optional<User> user = userService.getUserName(userId);
        return user;
    }

    @PostMapping("/")
    public ResponseEntity<User> addOrderDetails(@RequestBody User user) {

        User addUser = userService.addUser(user);
        return ResponseEntity.ok(addUser);
    }
}
