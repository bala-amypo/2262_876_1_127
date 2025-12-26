package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repo;

    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;


        if (complaint.getSeverity() == Complaint.Severity.CRITICAL) score += 10;
        else if (complaint.getSeverity() == Complaint.Severity.HIGH) score += 5;
        else if (complaint.getSeverity() == Complaint.Severity.MEDIUM) score += 3;


        if (complaint.getUrgency() == Complaint.Urgency.IMMEDIATE) score += 5;
        else if (complaint.getUrgency() == Complaint.Urgency.HIGH) score += 3;


        for (PriorityRule rule : getActiveRules()) {
            score += rule.getWeight();
        }

        return score;
    }
}
