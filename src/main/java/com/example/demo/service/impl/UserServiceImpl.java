package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    // ===== Constructor REQUIRED by tests =====
    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    // ===== TEST-EXPECTED METHOD =====
    @Override
    public User registerCustomer(String name, String email, String password) {
        
        // Validate email format
        if (!isValidEmail(email)) {
            throw new RuntimeException("Invalid email format");
        }

        if (repo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(User.Role.CUSTOMER);

        return repo.save(user);
    }

    // ===== TEST-EXPECTED METHOD =====
    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // ===== YOUR EXISTING METHOD (enhanced with password hashing) =====
    @Override
    public User registerUser(User user) {
        user.setId(null);
        
        // Validate email format
        if (user.getEmail() != null && !isValidEmail(user.getEmail())) {
            throw new RuntimeException("Invalid email format");
        }
        
        // Hash password if it's not already hashed
        if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        
        try {
            return repo.save(user);
        } catch (Exception e) {
            throw new RuntimeException("This Email has already been registered");
        }
    }

    // ===== YOUR EXISTING METHOD (enhanced with password validation) =====
    @Override
    public User loginUser(User user) {

        Optional<User> dbUser = repo.findByEmail(user.getEmail());
        if (dbUser.isEmpty()) {
            throw new RuntimeException("Email not found!");
        }

        User existingUser = dbUser.get();

        // Check if password is hashed (new) or plain (legacy)
        boolean isValidPassword;
        if (existingUser.getPassword().startsWith("$2a$")) {
            // Hashed password - use encoder to match
            isValidPassword = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
        } else {
            // Legacy plain password
            isValidPassword = existingUser.getPassword().equals(user.getPassword());
        }
        
        if (!isValidPassword) {
            throw new RuntimeException("Invalid Password!");
        }

        return existingUser;
    }
    
    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
