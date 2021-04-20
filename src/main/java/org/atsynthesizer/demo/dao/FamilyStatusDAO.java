package com.example.demo.dao;

import com.example.demo.entity.FamilyStatus;

import java.util.List;

public interface FamilyStatusDAO {
    List<FamilyStatus> allFamilyStatuses();
    void add(FamilyStatus familyStatus);
    void delete(FamilyStatus familyStatus);
    void edit(FamilyStatus familyStatus);
    FamilyStatus getById(int id);
    int familyStatusesCount() ;
}
