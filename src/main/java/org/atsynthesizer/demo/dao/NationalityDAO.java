package com.example.demo.dao;

import com.example.demo.entity.Nationality;

import java.util.List;

public interface NationalityDAO {
    List<Nationality> allNationalities();
    void add(Nationality nationality);
    void delete(Nationality nationality);
    void edit(Nationality nationality);
    Nationality getById(int id);
    int nationalitiesCount() ;
}
