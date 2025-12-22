package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;
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
    
    enum Role role{

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

}