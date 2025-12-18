package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User{
    @Id
    private long id;
    //@Column("unique=true)";
    private String email;
    private String name, password;

    public long getId(){
        return this.id;
    }

    public long setId(int id){
        this.id = id;
    }


    public String getName(){
        return this.name;
    }

    public String setName(String name){
        this.name = name;
    }


    public String getEmail(){
        return this.email;
    }

    public String setEmail(String email){
        this.email = email;
    }


    public String getPassword(){
        return this.password;
    }

    public String setPassword(String password){
        this.password = password;
    }

    public User(long id, String name, String email, String password){
        this.id = id
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(){
        
    }
}