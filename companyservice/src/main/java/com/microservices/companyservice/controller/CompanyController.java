package com.microservices.companyservice.controller;

import com.microservices.companyservice.model.Company;
import com.microservices.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/getCompanies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/getById/{cId}")
    public Company getCompanyById(@PathVariable  Long cId){
        return companyService.getCompanyById(cId);
    }
    @PostMapping("/createCompany")
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }
    @PutMapping("/updateCompany")
    public void updateCompany(@RequestBody Company company){
        companyService.updateCompany(company);
    }
}
