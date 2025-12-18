package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Complaint{
    @Id
    private long id;
    private String title, description, category;
    private int priorityScore;
    private LocalDateTime submittedOn;
    

    public long getId(){
        return this.id;
    }

    public void setId(int id){
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
        return this.password;
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

    public Complaint(){
        
    }

    public Complaint(){

    }
}