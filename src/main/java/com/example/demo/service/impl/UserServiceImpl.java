package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.*;

public class PriorityRuleServiceImpl implements PriorityRuleService{
    @Autowired
    UserRepository repo;
    public User registerUser(User user){
        repo.save(user);
    }
}