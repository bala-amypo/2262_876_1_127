package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private PriorityRuleRepository repo;

    @Autowired
    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    public PriorityRuleServiceImpl() {
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }


}
