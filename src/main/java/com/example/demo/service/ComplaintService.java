package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.Complaint;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

public interface ComplaintService{
    public Complaint submitComplaint(Complaint request);
    public List<Complaint> getUserComplaints(Long userId);
    public List<Complaint> getPrioritizedComplaints();
    public void updateComplaintStatus(Long id, String status);
}