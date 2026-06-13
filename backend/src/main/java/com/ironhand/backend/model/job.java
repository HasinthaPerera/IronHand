package com.ironhand.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "jobs")
public class job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("category")
    private String category;

    @JsonProperty("description")
    private String description;

    @JsonProperty("budget")
    private Double budget;

    @JsonProperty("location")
    private String location;

    @JsonProperty("postedBy")
    private String postedBy;

    @JsonProperty("createdAt")
    private java.time.LocalDateTime createdAt;

    // Manual Getters and Setters to avoid Lombok naming issues
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPostedBy() { return postedBy; }
    public void setPostedBy(String postedBy) { this.postedBy = postedBy; }

    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
}