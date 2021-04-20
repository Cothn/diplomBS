package com.example.demo.dao;

import com.example.demo.entity.Disability;

import java.util.List;

public interface DisabilityDAO {
    List<Disability> allDisabilities();
    void add(Disability disability);
    void delete(Disability disability);
    void edit(Disability disability);
    Disability getById(int id);
    int disabilitiesCount() ;
}
