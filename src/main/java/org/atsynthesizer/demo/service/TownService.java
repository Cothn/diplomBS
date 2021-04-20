package com.example.demo.service;

import com.example.demo.entity.Town;

import java.util.List;

public interface TownService {

    public List<Town> allTowns();

    int getTownsCount();

    public void add(Town town);


    public void delete(Town town);


    public void edit(Town town);


    public Town getById(int id);
}
