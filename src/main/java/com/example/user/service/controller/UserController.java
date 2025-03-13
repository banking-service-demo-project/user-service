package com.example.user.service.controller;

import com.example.user.service.dto.User;
import com.example.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public User getUserWithAccount(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public Collection<User> getUserAll() {
        return userService.getAllUsers();
    }
}
