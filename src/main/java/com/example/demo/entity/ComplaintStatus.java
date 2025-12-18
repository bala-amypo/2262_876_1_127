package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplaintService{
    @Id
    private long id;
    private String status;
    private int baseScore;

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

    public ComplaintService(){

    }

    public ComplaintService(){
        
    }
}