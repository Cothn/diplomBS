package com.example.demo.service;

import com.example.demo.entity.Nationality;

import java.util.List;

public interface NationalityService {

    public List<Nationality> allNationalities();

    int getNationalitiesCount();

    public void add(Nationality nationality);


    public void delete(Nationality nationality);


    public void edit(Nationality nationality);


    public Nationality getById(int id);
}
