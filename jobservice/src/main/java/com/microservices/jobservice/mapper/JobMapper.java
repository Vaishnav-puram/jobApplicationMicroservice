package com.microservices.jobservice.mapper;

import com.microservices.jobservice.dto.JobDTO;
import com.microservices.jobservice.external.Company;
import com.microservices.jobservice.external.Review;
import com.microservices.jobservice.model.Job;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobDTO(Job job, Company company, List<Review> reviewList){
        JobDTO jobDTO =new JobDTO();
        jobDTO.setJobId(job.getJobId());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setMaxSal(job.getMaxSal());
        jobDTO.setMinSal(job.getMinSal());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompany(company);
        jobDTO.setReview(reviewList);
        return jobDTO;
    }
}
