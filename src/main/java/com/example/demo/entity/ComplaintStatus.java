package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private LocalDateTime updatedOn;
    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private ComplaintObj complaint;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public ComplaintObj getComplaint(){
        return this.complaint;
    }

    public void setComplaint(ComplaintObj complaint){
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

    public ComplaintStatus(long id, String status, ComplaintObj complaint){
        this.id = id;
        this.status = status;
        this.complaint = complaint;
    }

    public ComplaintStatus(){
        
    }
}