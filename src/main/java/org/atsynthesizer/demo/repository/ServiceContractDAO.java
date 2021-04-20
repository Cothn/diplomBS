package com.example.demo.dao;

import com.example.demo.entity.ServiceContract;

import java.util.List;

public interface ServiceContractDAO {
    public List<ServiceContract> allServiceContracts(int page);

    int getServiceContractsCount();

    public void add(ServiceContract serviceContract);


    public void delete(ServiceContract serviceContract);


    public void edit(ServiceContract serviceContract);


    public ServiceContract getById(int id);
}
