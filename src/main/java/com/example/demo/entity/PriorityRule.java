package com.example.demo.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    private String category;
    private String description;

    // already existed
    private int baseScore;

    // REQUIRED BY TESTS
    private String ruleName;
    private int weight;
    private boolean active = true;

    public PriorityRule() {
        this.baseScore = 10;
    }

    public PriorityRule(String category, String description, int baseScore) {
        this.category = category;
        this.description = description;
        this.baseScore = baseScore;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseScore() {
        return baseScore;
    }

    public String getRuleName() {
        return ruleName;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBaseScore(int baseScore) {
        this.baseScore = baseScore;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
