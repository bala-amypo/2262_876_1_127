package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PriorityRule{
    @Id
    private long id;
    private String category, description;
    private int baseScore;

    public long getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
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

    public PriorityRule(){

    }
    
    public PriorityRule(){
        
    }
}