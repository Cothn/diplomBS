package com.example.demo.service;

import com.example.demo.entity.ServiceTerms;

import java.util.List;

public interface ServiceTermsService {
    public List<ServiceTerms> allServiceTermses(int page);

    int getServiceTermsesCount();

    public void add(ServiceTerms serviceTerms);


    public void delete(ServiceTerms serviceTerms);


    public void edit(ServiceTerms serviceTerms);


    public ServiceTerms getById(int id);
}
