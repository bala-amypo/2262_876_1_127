package com.example.demo.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PriorityRule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    private String category, description;
    private int baseScore;

private String ruleName;
private int weight;
private boolean active = true;


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
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

    public void setBaseScore(int baseScore){
        this.baseScore = baseScore;
    }

public String getRuleName() {
    return ruleName;
}

public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
}

public int getWeight() {
    return weight;
}

public void setWeight(int weight) {
    this.weight = weight;
}

public boolean isActive() {
    return active;
}

public void setActive(boolean active) {
    this.active = active;
}


    public PriorityRule(String category, String description, int baseScore){
        this.category = category;
        this.description = description;
        this.baseScore = baseScore;
    }
    
    public PriorityRule(){
        this.baseScore = 10;
    }
}