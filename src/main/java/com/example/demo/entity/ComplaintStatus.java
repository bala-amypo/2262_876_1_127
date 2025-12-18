package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatus{
    @Id
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

    @PreUpdate
    public void setUpdatedOn(LocalDateTime updatedOn){
        this.updatedOn = updatedOn;
    }

    public ComplaintStatus(long id, String status, ComplaintObj complaint, LocalDateTime updatedOn){
        this.id = id;
        this.status = status;
        this.complaint = complaint;
        this.updatedOn = updatedOn;
    }

    public ComplaintStatus(){
        
    }
}