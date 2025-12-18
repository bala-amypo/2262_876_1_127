package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User{
    @Id
    private long id;
    private String status;
    private int baseScore;

    public long getId(){
        return this.id;
    }

    public long setId(int id){
        this.id = id;
    }


    public String getStatus(){
        return this.status;
    }

    public String setStatus(String status){
        this.status = status;
    }


    public String getDescription(){
        return this.description;
    }

    public String setDescription(String description){
        this.description = description;
    }


    public int getBaseScore(){
        return this.baseScore;
    }

    public int setBaseScore(String baseScore){
        this.baseScore = baseScore;
    }
}