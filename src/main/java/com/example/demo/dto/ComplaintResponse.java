package com.example.demo.dto;

import com.example.demo.entity.Complaint;
import java.time.LocalDateTime;

public class ComplaintResponse {
    
    private Long id;
    private String title;
    private String description;
    private String category;
    private String channel;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;
    private Complaint.Status status;
    private Double priorityScore;
    private LocalDateTime createdAt;
    private String customerEmail;
    
    public ComplaintResponse() {}
    
    public ComplaintResponse(Long id, String title, String description, String category, 
                           String channel, Complaint.Severity severity, Complaint.Urgency urgency,
                           Complaint.Status status, Double priorityScore, LocalDateTime createdAt,
                           String customerEmail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.channel = channel;
        this.severity = severity;
        this.urgency = urgency;
        this.status = status;
        this.priorityScore = priorityScore;
        this.createdAt = createdAt;
        this.customerEmail = customerEmail;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getChannel() {
        return channel;
    }
    
    public void setChannel(String channel) {
        this.channel = channel;
    }
    
    public Complaint.Severity getSeverity() {
        return severity;
    }
    
    public void setSeverity(Complaint.Severity severity) {
        this.severity = severity;
    }
    
    public Complaint.Urgency getUrgency() {
        return urgency;
    }
    
    public void setUrgency(Complaint.Urgency urgency) {
        this.urgency = urgency;
    }
    
    public Complaint.Status getStatus() {
        return status;
    }
    
    public void setStatus(Complaint.Status status) {
        this.status = status;
    }
    
    public Double getPriorityScore() {
        return priorityScore;
    }
    
    public void setPriorityScore(Double priorityScore) {
        this.priorityScore = priorityScore;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
