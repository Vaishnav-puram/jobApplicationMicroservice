package com.microservices.jobservice.service;


import com.microservices.jobservice.dto.JobWithCompanyDTO;
import com.microservices.jobservice.external.Company;
import com.microservices.jobservice.model.Job;
import com.microservices.jobservice.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepo jobRepo;

    private JobWithCompanyDTO convertToDTO(Job job){
        RestTemplate restTemplate=new RestTemplate();
        Company company=restTemplate.getForObject("http://localhost:8083/company/getById/"+job.getCompanyId() ,Company.class);
        System.out.println("Company --> "+company.getName());
        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
        jobWithCompanyDTO.setJob(job);
        jobWithCompanyDTO.setCompany(company);
        return jobWithCompanyDTO;
    }

    @Override
    public List<JobWithCompanyDTO> getJobs() {
        List<Job> jobs=jobRepo.findAll();
//        List<JobWithCompanyDTO> jobWithCompanyDTOS=new ArrayList<>();
//        RestTemplate restTemplate=new RestTemplate();

//        for (Job job:jobs){
//            JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
//            jobWithCompanyDTO.setJob(job);
//            Company company=restTemplate.getForObject("http://localhost:8083/company/getById/"+job.getCompanyId() ,Company.class);
//            System.out.println("Company --> "+company.getName());
//            jobWithCompanyDTO.setCompany(company);
//            jobWithCompanyDTOS.add(jobWithCompanyDTO);
//        }
//        return jobWithCompanyDTOS;
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public JobWithCompanyDTO getJobById(Long jobId) {
        Job job=jobRepo.findById(jobId).orElseThrow();
        return convertToDTO(job);
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
