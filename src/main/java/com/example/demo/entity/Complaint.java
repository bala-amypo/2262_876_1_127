package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Complaint{
    @Id
    private long id;
    private String title, description, category;
    private int priorityScore

    public long getId(){
        return this.id;
    }

    public long setId(int id){
        this.id = id;
    }


    public String getTitle(){
        return this.title;
    }

    public String setTitle(String title){
        this.title = title;
    }


    public String getDescription(){
        return this.description;
    }

    public String setDescription(String description){
        this.description = description;
    }


    public String getCategory(){
        return this.password;
    }

    public String setCategory(String password){
        this.password = password;
    }

    public Complaint(){
        
    }

    public Complaint(){

    }
}