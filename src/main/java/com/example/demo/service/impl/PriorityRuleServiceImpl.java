package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.entity.Complaint;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService{

    @Autowired
    PriorityRuleServiceRepository repo;

    public List<PriorityRule> getAllRules(){
        returnrepo.findAll();
    }
}