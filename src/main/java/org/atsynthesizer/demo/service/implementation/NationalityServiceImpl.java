package com.example.demo.service.implementation;

import com.example.demo.dao.NationalityDAO;
import com.example.demo.entity.Nationality;
import com.example.demo.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NationalityServiceImpl implements NationalityService {


    private NationalityDAO nationalityDAO;

    @Autowired
    public void setNationalityDAO(NationalityDAO nationalityDAO) {
        this.nationalityDAO = nationalityDAO;
    }

    @Override
    @Transactional
    public List<Nationality> allNationalities() {
        return nationalityDAO.allNationalities();
    }

    @Override
    @Transactional
    public int getNationalitiesCount() {
        return nationalityDAO.nationalitiesCount();
    }

    @Override
    @Transactional
    public void add(Nationality nationality) {
        nationalityDAO.add(nationality);
    }

    @Override
    @Transactional
    public void delete(Nationality nationality) {
        nationalityDAO.delete(nationality);
    }

    @Override
    @Transactional
    public void edit(Nationality nationality) {
        nationalityDAO.edit(nationality);
    }

    @Override
    @Transactional
    public Nationality getById(int id) {
        return nationalityDAO.getById(id);
    }
}
