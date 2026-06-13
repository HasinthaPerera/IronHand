package com.ironhand.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

@Entity
@Table(name = "proposals")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("jobId")
    private Long jobId;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("applicantEmail")
    private String applicantEmail;

    @JsonProperty("pitch")
    @Column(length = 1000)
    private String pitch;

    @JsonProperty("bid")
    private Double bid;

    @JsonProperty("status")
    private String status; // PENDING, ACCEPTED, REJECTED

    @JsonProperty("jobOwnerEmail")
    private String jobOwnerEmail;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }

    public String getPitch() { return pitch; }
    public void setPitch(String pitch) { this.pitch = pitch; }

    public Double getBid() { return bid; }
    public void setBid(Double bid) { this.bid = bid; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getJobOwnerEmail() { return jobOwnerEmail; }
    public void setJobOwnerEmail(String jobOwnerEmail) { this.jobOwnerEmail = jobOwnerEmail; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
