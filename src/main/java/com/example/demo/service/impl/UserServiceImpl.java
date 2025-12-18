package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;

    public User registerUser(User user){
        return repo.save(user);
    }
    public User loginUser(User user){
        return repo.save(user);
    }
}