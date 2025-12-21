package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository repo;

    @Override
    public User registerUser(User user) {
        
        try{
        User newUser = repo.save(user);
        }
        catch(Exception e){
        
    }


    @Override
    public User loginUser(User user) {
        Optional<User> dbUser = repo.findByEmail(user.getEmail());
        if (dbUser.isEmpty()) {
            throw new RuntimeException("Email not found!");
        }

        User existingUser = dbUser.get();
        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid Password!");
        }

        return existingUser;
    }

}
