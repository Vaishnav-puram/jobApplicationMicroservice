package com.microservices.jobservice.service;


import com.microservices.jobservice.model.Job;

import java.util.List;

public interface JobService {
    List<Job> getJobs();
    void createJob(Job job);
    Job getJobById(Long jobId);
    void deleteJobById(Long jobId);
    void updateJob(Job job);
}
