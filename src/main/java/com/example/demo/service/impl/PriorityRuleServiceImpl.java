package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.repository.PriorityRuleRepository;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService{

    @Autowired
    PriorityRuleRepository repo;

    public List<PriorityRule> getAllRules(){
        return repo.findAll();
    }
}