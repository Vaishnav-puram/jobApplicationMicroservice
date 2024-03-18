package com.microservices.jobservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column(length = 500)
    private String title;
    @Column(length = 5000)
    private String description;
    private String maxSal;
    private String minSal;
    @Column(length = 500)
    private String location;
    private Long companyId;
    public Job() {
    }

    public Job(Long jobId, String title, String description, String maxSal, String minSal, String location) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.maxSal = maxSal;
        this.minSal = minSal;
        this.location = location;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(String maxSal) {
        this.maxSal = maxSal;
    }

    public String getMinSal() {
        return minSal;
    }

    public void setMinSal(String minSal) {
        this.minSal = minSal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
