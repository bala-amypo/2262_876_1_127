package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;


@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Autowired
    PriorityRuleRepository repo;

    @Override
    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }

}
