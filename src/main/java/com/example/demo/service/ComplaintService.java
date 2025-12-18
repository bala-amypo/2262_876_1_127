package com.example.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;


public interface ComplaintService{
    public User submitComplaint(ComplaintRequest request);
    public List<Complaint> getUserComplaints(Long userId);
    public List<Complaint> getPrioritizedComplaints();
    public void updateComplaintStatus(Long id, String status);
}