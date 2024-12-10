package com.project.database.controller;

import com.project.database.entity.User;
import com.project.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        // Save the user to the database
        return userService.createUser(user);
    }
    
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {

        // Perform user login using email and password
        return userService.loginUser(user.getEmail(), user.getPassword());
    }

}
