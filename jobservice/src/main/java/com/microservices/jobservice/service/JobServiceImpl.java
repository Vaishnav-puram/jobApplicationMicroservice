package com.microservices.jobservice.service;


import com.microservices.jobservice.model.Job;
import com.microservices.jobservice.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepo.findById(jobId).orElseThrow();
    }

    @Override
    public void deleteJobById(Long jobId) {
        jobRepo.deleteById(jobId);
    }

    @Override
    public void updateJob(Job job) {
        Job oldJob=jobRepo.findById(job.getJobId()).orElseThrow();
        oldJob.setJobId(job.getJobId());
        oldJob.setDescription(job.getDescription());
        oldJob.setLocation(job.getLocation());
        oldJob.setTitle(job.getTitle());
        oldJob.setMaxSal(job.getMaxSal());
        oldJob.setMinSal(job.getMinSal());
        jobRepo.save(oldJob);
    }
}
