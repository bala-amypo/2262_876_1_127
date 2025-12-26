package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {


    User registerUser(User user);

    User loginUser(User user);


























    User registerCustomer(String name, String email, String password);

    User findByEmail(String email);
}
