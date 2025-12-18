package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.*;

public interface PriorityRuleService {
    public User registerUser(User user);
    public User loginUser(User user);
}