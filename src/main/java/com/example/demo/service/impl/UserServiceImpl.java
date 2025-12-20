package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;


public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
    this.repo = repo;
}


    @Override
    public User registerUser(User user) {
        return repo.save(user);
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

    @Override
    public User registerCustomer(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setFullName(name); 
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(User.Role.CUSTOMER);

        return repo.save(user);
    }
    @Override
public User findByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
}

}
