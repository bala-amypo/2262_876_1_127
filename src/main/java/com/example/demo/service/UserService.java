package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Complaint;
import java.util.*;
import com.example.demo.entity.PriorityRule;

public interface PriorityRuleService {
    public List<PriorityRule> getAllRules();
}