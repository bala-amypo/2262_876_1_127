package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // ===== Existing field (kept) =====
    @NotBlank(message = "Name is required")
    private String name;

    // ===== Alias for tests =====
    @Transient
    private String fullName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private String password;

    @Schema(hidden = true)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER,
        AGENT,
        ADMIN,
        CUSTOMER
    }

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = Role.CUSTOMER;
        }
        if (this.name == null && this.fullName != null) {
            this.name = this.fullName;
        }
        // Validate email format
        if (this.email != null && !isValidEmail(this.email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    // ===== Constructors =====
    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.fullName = name;
        this.email = email;
        this.password = password;
        this.role = Role.CUSTOMER;
    }

    // ===== Getters =====
    public Long getId() { return id; }

    public String getEmail() { return email; }

    public String getName() { return name; }

    // === Test expected ===
    public String getFullName() {
        return fullName != null ? fullName : name;
    }

    public String getPassword() { return password; }

    public Role getRole() { return role; }

    // ===== Setters =====
    public void setId(Long id) { this.id = id; }

    public void setEmail(String email) { this.email = email; }

    public void setName(String name) {
        this.name = name;
        this.fullName = name;
    }

    // === Test expected ===
    public void setFullName(String fullName) {
        this.fullName = fullName;
        this.name = fullName;
    }

    public void setPassword(String password) { this.password = password; }

    public void setRole(Role role) { this.role = role; }
}
