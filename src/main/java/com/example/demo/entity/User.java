package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User{
    @Id
    private long id;
    private String name, email, password;

    public long getId(){
        return this.id;
    }

    public long setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public getName(this)
}