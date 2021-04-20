package com.example.demo.service;

import com.example.demo.entity.Disability;

import java.util.List;

public interface DisabilityService {

    public List<Disability> allDisabilities();

    int getDisabilitiesCount();

    public void add(Disability disability);


    public void delete(Disability disability);


    public void edit(Disability disability);


    public Disability getById(int id);
}
