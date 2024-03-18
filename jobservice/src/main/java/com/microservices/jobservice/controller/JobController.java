package com.microservices.jobservice.controller;

import com.microservices.jobservice.model.Job;
import com.microservices.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/getJobs")
    public List<Job> getJobs(){
        return jobService.getJobs();
    }
    @PostMapping("/createJob")
    public Job createJob(@RequestBody Job job){
        jobService.createJob(job);
        return job;
    }

    @GetMapping("/getById/{jobId}")
    public Job getById(@PathVariable Long jobId){
        return jobService.getJobById(jobId);
    }
    @PutMapping("/updateJob")
    public void updateJob(@RequestBody Job job){
        jobService.updateJob(job);
    }
    @DeleteMapping("/deleteJob")
    public void deleteJob(@PathVariable Long jobId){
        jobService.deleteJobById(jobId);
    }
}