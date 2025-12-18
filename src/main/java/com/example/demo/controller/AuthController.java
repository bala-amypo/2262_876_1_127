package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserService service;
    public User registerUser(@RequestBody User user){
        service.registerUser(user);
    }
}
