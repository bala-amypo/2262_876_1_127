package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String email;
    private String name;
    @JsonIgnore
    private String password;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(){
        
    }
}