package com.microservices.companyservice.service;


import com.microservices.companyservice.model.Company;
import com.microservices.companyservice.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public List<Company> getCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public Company getCompanyById(Long cId) {
        return companyRepo.findById(cId).orElseThrow();
    }

    @Override
    public void updateCompany(Company company) {
        Company comp=companyRepo.findById(company.getcId()).orElseThrow();
        comp.setName(company.getName());
        companyRepo.save(comp);
    }
}
