package com.example.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;

    public User registerUser(User user){
        return repo.save(user);
    }
    public User loginUser(User user){
        User dbUser = repo.findByEmail(user.getEmail());
        if(dbUser.isEmpty())
            throw new RunTimeException("Email not found!");
        if(!user.password.equals(user.getpassword()))
            throw new RunTimeException("Invalid Password!");

        return user;
    }
}