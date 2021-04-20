package com.example.demo.service;

import com.example.demo.entity.FamilyStatus;

import java.util.List;

public interface FamilyStatusService {

    public List<FamilyStatus> allFamilyStatuses();

    int getFamilyStatusesCount();

    public void add(FamilyStatus familyStatus);


    public void delete(FamilyStatus familyStatus);


    public void edit(FamilyStatus familyStatus);


    public FamilyStatus getById(int id);
}
