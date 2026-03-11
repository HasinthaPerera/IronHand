package com.ironhand.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String bio;
    private Double rate;
    private Double rating;
    private String icon;

    // Standard Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // ... repeat for other fields
}