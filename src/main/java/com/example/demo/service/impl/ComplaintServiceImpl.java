package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import java.time.LocalDateTime;
import com.example.demo.entity.User;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.dto.ComplaintRequest;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    ComplaintRepository repo;

    @Autowired
    ComplaintStatusRepository statusRepo;

    @Autowired
    UserRepository userRepo;

@Override
public Complaint submitComplaint(Complaint request) {

    Complaint saved = complaintRepo.save(request);

    if (priorityRuleRepo.count() == 0) {

        PriorityRule rule = new PriorityRule();
        rule.setCategory(saved.getCategory() != null ? saved.getCategory() : "GENERAL");
        rule.setDescription("Auto-generated rule from complaint submission");
        rule.setBaseScore(10);

        priorityRuleRepo.save(rule);
    }

    return saved;
}


    @Override
    public List<Complaint> getUserComplaints(Long userId){
        return repo.findByUserId(userId);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints(){
        return repo.findAll();
    }

    @Override
    public void updateComplaintStatus(Long id, String status){
    Complaint complaint = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Complaint not found"));

    ComplaintStatus cs = new ComplaintStatus();
    cs.setStatus(status);
    cs.setComplaint(complaint);

    statusRepo.save(cs);
}
    
}
