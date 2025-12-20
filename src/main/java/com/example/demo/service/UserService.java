package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.*;

public interface UserService {
    public User registerUser(User user);
    public User loginUser(User user);
    public User registerCustomer(String name, String email, String password);

}