package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.ComplaintStatus;
import java.time.LocalDateTime;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    ComplaintRepository repo;
    @Autowired
    ComplaintStatusRepository statusRepo;

    public Complaint submitComplaint(Complaint request){

    Complaint saved = repo.save(request);
    ComplaintStatus status = new ComplaintStatus();
    status.setStatus("OPEN");
    status.setComplaint(saved);
    statusRepo.save(status);
    return saved;
}


    public List<Complaint> getUserComplaints(Long userId){
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
    cs.setUpdatedOn(LocalDateTime.now());
    cs.setComplaint(complaint);

    statusRepo.save(cs);
}
    
}