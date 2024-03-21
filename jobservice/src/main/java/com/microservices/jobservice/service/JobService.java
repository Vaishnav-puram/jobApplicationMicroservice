package com.microservices.jobservice.service;


import com.microservices.jobservice.dto.JobDTO;
import com.microservices.jobservice.model.Job;

import java.util.List;

public interface JobService {
    List<JobDTO> getJobs();
    void createJob(Job job);
    JobDTO getJobById(Long jobId);
    void deleteJobById(Long jobId);
    void updateJob(Job job);
}
