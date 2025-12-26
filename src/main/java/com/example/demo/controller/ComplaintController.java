package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import jakarta.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.UnauthorizedException;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public ResponseEntity<ComplaintResponse> submitComplaint(@Valid @RequestBody ComplaintRequest request) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        
        try {
            User customer = userService.findByEmail(userEmail);
            
            Complaint complaint = new Complaint();
            complaint.setTitle(request.getTitle());
            complaint.setDescription(request.getDescription());
            complaint.setCategory(request.getCategory());
            complaint.setChannel(request.getChannel());
            complaint.setSeverity(request.getSeverity());
            complaint.setUrgency(request.getUrgency());
            complaint.setCustomer(customer);
            
            Complaint savedComplaint = complaintService.submitComplaint(complaint);
            ComplaintResponse response = mapToResponse(savedComplaint);
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("User not found")) {
                throw new UnauthorizedException("User not found with email: " + userEmail);
            }
            throw new BadRequestException("Failed to submit complaint: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ComplaintResponse>> getUserComplaints(@PathVariable Long userId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long currentUserId = (Long) auth.getDetails();
        
        // Users can only view their own complaints unless they're AGENT/ADMIN
        boolean hasAdminAccess = auth.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_AGENT") || a.getAuthority().equals("ROLE_ADMIN"));
            
        if (!hasAdminAccess && !currentUserId.equals(userId)) {
            throw new UnauthorizedException("You can only view your own complaints");
        }
        
        List<Complaint> complaints = complaintService.getUserComplaints(userId);
        List<ComplaintResponse> responses = complaints.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<ComplaintResponse>> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        List<ComplaintResponse> responses = complaints.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Void> updateComplaintStatus(@PathVariable Long id, @RequestParam String status) {
        complaintService.updateComplaintStatus(id, status);
        return ResponseEntity.ok().build();
    }
    
    private ComplaintResponse mapToResponse(Complaint complaint) {
        return new ComplaintResponse(
            complaint.getId(),
            complaint.getTitle(),
            complaint.getDescription(),
            complaint.getCategory(),
            complaint.getChannel(),
            complaint.getSeverity(),
            complaint.getUrgency(),
            complaint.getStatus(),
            complaint.getPriorityScore() != null ? complaint.getPriorityScore().doubleValue() : 0.0,
            complaint.getSubmittedOn(),
            complaint.getCustomer() != null ? complaint.getCustomer().getEmail() : null
        );
    }
}
