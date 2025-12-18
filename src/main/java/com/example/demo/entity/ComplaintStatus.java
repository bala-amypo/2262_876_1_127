package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintService{
    @Id
    private long id;
    private String status;
    private int baseScore;
    private LocalDateTime updatedOn;

    public long getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public int getBaseScore(){
        return this.baseScore;
    }

    public void setBaseScore(String baseScore){
        this.baseScore = baseScore;
    }

    public LocalDateTime getUpdatedOn(){
        return this.updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn){
        this.updatedOn = updatedOn;
    }

    public ComplaintService(long id, String status, int baseScore, LocalDateTime updatedOn){
        this.id = id;
        this.status = status;
        this.baseScore = baseScore;
        this.updatedOn = updatedOn;
    }

    public ComplaintService(){
        
    }
}