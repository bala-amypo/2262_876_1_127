package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private PriorityRuleRepository priorityRuleRepo;

    @Override
    public Complaint submitComplaint(Complaint request) {

        Complaint saved = complaintRepo.save(request);
        if (priorityRuleRepo.count() == 0) {

            PriorityRule rule = new PriorityRule();
            rule.setCategory(saved.getCategory());
            rule.setDescription("Auto-created rule from complaint submission");
            rule.setBaseScore(10);

            priorityRuleRepo.save(rule);
        }

        return saved;
    }
}

