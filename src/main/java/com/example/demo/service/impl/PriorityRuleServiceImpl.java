package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repo;

    @Autowired
    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }
@Override
public int computePriorityScore(Complaint complaint) {
    return 0;
}

}
