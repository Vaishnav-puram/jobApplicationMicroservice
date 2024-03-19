package com.microservices.jobservice.service;


import com.microservices.jobservice.dto.JobWithCompanyDTO;
import com.microservices.jobservice.model.Job;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> getJobs();
    void createJob(Job job);
    JobWithCompanyDTO getJobById(Long jobId);
    void deleteJobById(Long jobId);
    void updateJob(Job job);
}
