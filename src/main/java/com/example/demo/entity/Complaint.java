package com.example.demo.entity;

import jakarta.persistence.*;
java.util.*;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.User;



@Entity
public class Complaint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(required = true)
    private Long id;
    private String title, description, category, status;
    private int priorityScore;
    @Schema(hidden = true)
    private LocalDateTime submittedOn;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

@Transient
private List<PriorityRule> priorityRules = new ArrayList<>();

public List<PriorityRule> getPriorityRules() {
    return priorityRules;
}


@Enumerated(EnumType.STRING)
private Severity severity;

@Enumerated(EnumType.STRING)
private Urgency urgency;

private User assignedAgent;

public void setAssignedAgent(User agent) {
    this.assignedAgent = agent;
}

public User getAssignedAgent() {
    return assignedAgent;
}


public enum Severity {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}


public enum Urgency {
    LOW,
    MEDIUM,
    HIGH,
    IMMEDIATE
}

public User getCustomer() {
    return this.user;
}

public void setCustomer(User user) {
    this.user = user;
}

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public int getPriorityScore(){
        return this.priorityScore;
    }

    public void setPriorityScore(int priorityScore){
        this.priorityScore = priorityScore;
    }

    public LocalDateTime getSubmittedOn(){
        return this.submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn){
        this.submittedOn = submittedOn;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Severity getSeverity() {
    return severity;
}

public void setSeverity(Severity severity) {
    this.severity = severity;
}

public Urgency getUrgency() {
    return urgency;
}

public void setUrgency(Urgency urgency) {
    this.urgency = urgency;
}
public String getStatus() {
    return status;
}


    @PrePersist
    public void onCreate() {
    this.submittedOn = LocalDateTime.now();
   }
    public Complaint(String title, String description, String category, int priorityScore, User user){
        this.title = title;
        this.description = description;
        this.category = category;
        this.priorityScore = priorityScore;
        this.user = user;
    }

    public Complaint(){

    }
    private String channel;

public String getChannel() {
    return channel;
}

public void setChannel(String channel) {
    this.channel = channel;
}

}