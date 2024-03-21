package com.microservices.jobservice.clients;

import com.microservices.jobservice.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYSERVICE")
public interface CompanyClient {
    @GetMapping("/company/getById/{cId}")
    Company getCompany(@PathVariable Long cId);
}
