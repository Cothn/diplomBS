package com.example.demo.service.implementation;

import com.example.demo.dao.DisabilityDAO;
import com.example.demo.entity.Disability;
import com.example.demo.service.DisabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisabilityServiceImpl implements DisabilityService {


    private DisabilityDAO disabilityDAO;

    @Autowired
    public void setDisabilityDAO(DisabilityDAO disabilityDAO) {
        this.disabilityDAO = disabilityDAO;
    }

    @Override
    @Transactional
    public List<Disability> allDisabilities() {
        return disabilityDAO.allDisabilities();
    }

    @Override
    @Transactional
    public int getDisabilitiesCount() {
        return disabilityDAO.disabilitiesCount();
    }

    @Override
    @Transactional
    public void add(Disability disability) {
        disabilityDAO.add(disability);
    }

    @Override
    @Transactional
    public void delete(Disability disability) {
        disabilityDAO.delete(disability);
    }

    @Override
    @Transactional
    public void edit(Disability disability) {
        disabilityDAO.edit(disability);
    }

    @Override
    @Transactional
    public Disability getById(int id) {
        return disabilityDAO.getById(id);
    }
}
