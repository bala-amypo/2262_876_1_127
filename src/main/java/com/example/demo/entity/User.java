package com.example.demo.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

    public enum Role {
        USER, ADMIN, CUSTOMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(required = true)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    private String fullName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    public void setDefaults() {
        if (this.role == null) {
            this.role = Role.CUSTOMER;
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public User() {}
}
