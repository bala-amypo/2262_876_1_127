package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PriorityRule;

public interface PriorityRuleService {

    List<PriorityRule> getAllRules();
    int computePriorityScore(Complaint complaint);

}
