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
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import java.util.List;
import com.example.demo.repository.ComplaintRepository;


@Service
public class ComplaintServiceImpl implements ComplaintService{
@Autowired
private ComplaintRepository complaintRepository;

    @Autowired
    ComplaintRepository repo;
    @Autowired
    ComplaintStatusRepository statusRepo;

    @Autowired
    UserRepository userRepo;

@Override
public Complaint submitComplaint(Complaint request) {
    

    if (request.getUser() == null || request.getUser().getId() == null) {
        throw new IllegalArgumentException("user.id is required");
    }

    request.setId(null);

    Long userId = request.getUser().getId();
    User user = userRepo.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

    request.setUser(user);

    Complaint saved = repo.save(request);
    ComplaintStatus status = new ComplaintStatus();
    status.setStatus("OPEN");
    status.setComplaint(saved);
    statusRepo.save(status);

    return saved;
}


public ComplaintServiceImpl(
        ComplaintRepository repo,
        ComplaintStatusRepository statusRepo,
        UserRepository userRepo,
        PriorityRuleService priorityRuleService
) {
    this.repo = repo;
    this.statusRepo = statusRepo;
    this.userRepo = userRepo;
}
    public List<Complaint> getUserComplaints(Long userId){
        return repo.findByUserId(userId);
    }
    public List<Complaint> getComplaintsForUser(Long userId){
        return repo.findByUserId(userId);
    }

    public List<Complaint> getPrioritizedComplaints(){
        return repo.findAll();
    }

    public void updateComplaintStatus(Long id, String status){

    Complaint complaint = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Complaint not found"));

    ComplaintStatus cs = new ComplaintStatus();
    cs.setStatus(status);
    cs.setComplaint(complaint);

    statusRepo.save(cs);
}


@Override
public Complaint submitComplaint(ComplaintRequest request, User user) {
    Complaint complaint = new Complaint();
    complaint.setUser(user);
    complaint.setTitle(request.getTitle());
    complaint.setDescription(request.getDescription());
    return repo.save(complaint);
}

    
}