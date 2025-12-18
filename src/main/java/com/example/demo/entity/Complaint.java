package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title, description, category;
    private int priorityScore;
    private LocalDateTime submittedOn;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public long getId(){
        return this.id;
    }

    public void setId(long id){
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