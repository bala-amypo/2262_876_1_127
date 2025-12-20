package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import java.util.List;

public interface PriorityRuleService {

    List<PriorityRule> getAllRules();
    int computePriorityScore(Complaint complaint);

}
