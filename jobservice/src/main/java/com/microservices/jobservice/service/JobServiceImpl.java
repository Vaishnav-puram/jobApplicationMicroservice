package com.microservices.jobservice.service;


import com.microservices.jobservice.clients.CompanyClient;
import com.microservices.jobservice.clients.ReviewClient;
import com.microservices.jobservice.dto.JobDTO;
import com.microservices.jobservice.external.Company;
import com.microservices.jobservice.external.Review;
import com.microservices.jobservice.mapper.JobMapper;
import com.microservices.jobservice.model.Job;
import com.microservices.jobservice.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private ReviewClient reviewClient;

    private JobDTO convertToDTO(Job job){
        //RestTemplate restTemplate=new RestTemplate();
        //Company company=restTemplate.getForObject("http://COMPANYSERVICE:8083/company/getById/"+job.getCompanyId() ,Company.class);
        Company company=companyClient.getCompany(job.getCompanyId());
        System.out.println("Company --> "+company.getName());
//        ResponseEntity<List<Review>> reviewResponse =restTemplate.exchange(
//               "http://REVIEWSERVICE:8084/reviews?cId=" + job.getCompanyId(), HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });
//        List<Review> reviewList=reviewResponse.getBody();
        List<Review> reviewList=reviewClient.getReviews(job.getCompanyId());
        return JobMapper.mapToJobDTO(job,company,reviewList);
    }

    @Override
    public List<JobDTO> getJobs() {
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
    public JobDTO getJobById(Long jobId) {
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
