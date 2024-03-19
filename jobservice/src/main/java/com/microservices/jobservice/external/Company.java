package com.microservices.jobservice.external;

public class Company {
    private Long cId;
    private String name;

    public Company() {
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
