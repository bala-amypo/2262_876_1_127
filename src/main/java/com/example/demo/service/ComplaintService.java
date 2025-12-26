package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.dto.ComplaintRequest;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(Complaint request);

    List<Complaint> getUserComplaints(Long userId);

    List<Complaint> getPrioritizedComplaints();

    void updateComplaintStatus(Long id, String status);




















    Complaint submitComplaint(ComplaintRequest request, User user);

    List<Complaint> getComplaintsForUser(User user);
}
