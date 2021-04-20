package com.example.demo.service.implementation;

import com.example.demo.dao.FamilyStatusDAO;
import com.example.demo.entity.FamilyStatus;
import com.example.demo.service.FamilyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamilyStatusServiceImpl implements FamilyStatusService {


    private FamilyStatusDAO familyStatusDAO;

    @Autowired
    public void setFamilyStatusDAO(FamilyStatusDAO familyStatusDAO) {
        this.familyStatusDAO = familyStatusDAO;
    }

    @Override
    @Transactional
    public List<FamilyStatus> allFamilyStatuses() {
        return familyStatusDAO.allFamilyStatuses();
    }

    @Override
    @Transactional
    public int getFamilyStatusesCount() {
        return familyStatusDAO.familyStatusesCount();
    }

    @Override
    @Transactional
    public void add(FamilyStatus familyStatus) {
        familyStatusDAO.add(familyStatus);
    }

    @Override
    @Transactional
    public void delete(FamilyStatus familyStatus) {
        familyStatusDAO.delete(familyStatus);
    }

    @Override
    @Transactional
    public void edit(FamilyStatus familyStatus) {
        familyStatusDAO.edit(familyStatus);
    }

    @Override
    @Transactional
    public FamilyStatus getById(int id) {
        return familyStatusDAO.getById(id);
    }
}
