package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime updatedOn;
    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Complaint getComplaint(){
        return this.complaint;
    }

    public void setComplaint(Complaint complaint){
        this.complaint = complaint;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDateTime getUpdatedOn(){
        return this.updatedOn;
    }

    @PrePersist
    @PreUpdate
    public void setUpdatedOn(){
        this.updatedOn = LocalDateTime.now();
    }

    public ComplaintStatus(String status, Complaint complaint){
        this.status = status;
        this.complaint = complaint;
    }

    public ComplaintStatus(){
        
    }
}