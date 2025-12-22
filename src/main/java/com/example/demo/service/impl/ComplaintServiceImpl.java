package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository repo;

    @Autowired
    private ComplaintStatusRepository statusRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PriorityRuleRepository priorityRuleRepo;

    @Override
    public Complaint submitComplaint(Complaint request) {

        // save complaint
        Complaint saved = repo.save(request);

        // 🔥 AUTO-GENERATE rule if none exist
        if (priorityRuleRepo.count() == 0) {

            PriorityRule rule = new PriorityRule();
            rule.setCategory(
                saved.getCategory() != null ? saved.getCategory() : "GENERAL"
            );
            rule.setDescription("Auto-generated rule from complaint submission");
            rule.setBaseScore(10);

            priorityRuleRepo.save(rule);
        }

        return saved;
    }

    @Override
    public List<Complaint> getUserComplaints(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return repo.findAll();
    }

    @Override
    public void updateComplaintStatus(Long id, String status) {

        Complaint complaint = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));

        ComplaintStatus cs = new ComplaintStatus();
        cs.setStatus(status);
        cs.setComplaint(complaint);

        statusRepo.save(cs);
    }
}
