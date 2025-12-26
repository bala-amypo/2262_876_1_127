package com.example.demo.dto;

import com.example.demo.entity.Complaint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ComplaintRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must not exceed 200 characters")
    private String title;
    
    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    @NotBlank(message = "Channel is required")
    private String channel;
    
    @NotNull(message = "Severity is required")
    private Complaint.Severity severity;
    
    @NotNull(message = "Urgency is required")
    private Complaint.Urgency urgency;

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
}
