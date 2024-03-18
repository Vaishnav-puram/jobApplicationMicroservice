package com.microservices.companyservice.service;


import com.microservices.companyservice.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();
    Company createCompany(Company company);
    Company getCompanyById(Long cId);
    void updateCompany(Company company);
}
