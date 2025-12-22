package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String title;
    private String description;
    private String category;

    private int priorityScore;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private LocalDateTime submittedOn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Urgency urgency;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    @PrePersist
    public void onCreate() {
        this.submittedOn = LocalDateTime.now();
        this.status = Status.NEW;
        if (this.severity == null) {
            this.severity = Severity.LOW;
        }
        if(this.urgency == null){
            this.urgency = Urgency.LOW;
        }
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getPriorityScore() { return priorityScore; }
    public void setPriorityScore(int priorityScore) { this.priorityScore = priorityScore; }

    public LocalDateTime getSubmittedOn() { return submittedOn; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }

    public Urgency getUrgency() { return urgency; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }
 

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Complaint() {}

    public Complaint(String title, String description, String category,
                     int priorityScore, Severity severity, User user, Urgency urgency) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.priorityScore = priorityScore;
        this.severity = severity;
        this.urgency = urgency;
        this.user = user;
    }
}
