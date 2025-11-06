package com.neotox.currencyconverter.controller;

import com.neotox.currencyconverter.model.User;
import com.neotox.currencyconverter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User newUser = userService.registerUser(username, password);
        return "User registered: " + newUser.getUsername();
    }
}
