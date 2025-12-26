package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.validation.Valid;
import java.util.*;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.UnauthorizedException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthRequest request) {
        try {
            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            // Use role from request, default to CUSTOMER if null
            user.setRole(request.getRole() != null ? request.getRole() : User.Role.CUSTOMER);
            
            User savedUser = userService.registerUser(user);
            
            String token = jwtUtil.generateToken(savedUser.getEmail(), 
                                               savedUser.getRole().toString(), 
                                               savedUser.getId());
            
            AuthResponse response = new AuthResponse(token, savedUser.getEmail(), 
                                                   savedUser.getName(), 
                                                   savedUser.getRole().toString(), 
                                                   savedUser.getId());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody AuthRequest request) {
        try {
            User user = userService.findByEmail(request.getEmail());
            
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new UnauthorizedException("Invalid credentials");
            }
            
            String token = jwtUtil.generateToken(user.getEmail(), 
                                               user.getRole().toString(), 
                                               user.getId());
            
            AuthResponse response = new AuthResponse(token, user.getEmail(), 
                                                   user.getName(), 
                                                   user.getRole().toString(), 
                                                   user.getId());
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            throw new UnauthorizedException("Invalid credentials");
        }
    }
}
