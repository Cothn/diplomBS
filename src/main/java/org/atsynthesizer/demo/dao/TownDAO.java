package com.example.demo.dao;

import com.example.demo.entity.Town;

import java.util.List;

public interface TownDAO {
    List<Town> allTowns();
    void add(Town town);
    void delete(Town town);
    void edit(Town town);
    Town getById(int id);
    int townsCount() ;
}
