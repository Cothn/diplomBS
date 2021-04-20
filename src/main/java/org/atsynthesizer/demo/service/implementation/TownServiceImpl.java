package com.example.demo.service.implementation;

import com.example.demo.dao.TownDAO;
import com.example.demo.entity.Town;
import com.example.demo.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {


    private TownDAO townDAO;

    @Autowired
    public void setTownDAO(TownDAO townDAO) {
        this.townDAO = townDAO;
    }

    @Override
    @Transactional
    public List<Town> allTowns() {
        return townDAO.allTowns();
    }

    @Override
    @Transactional
    public int getTownsCount() {
        return townDAO.townsCount();
    }

    @Override
    @Transactional
    public void add(Town town) {
        townDAO.add(town);
    }

    @Override
    @Transactional
    public void delete(Town town) {
        townDAO.delete(town);
    }

    @Override
    @Transactional
    public void edit(Town town) {
        townDAO.edit(town);
    }

    @Override
    @Transactional
    public Town getById(int id) {
        return townDAO.getById(id);
    }
}
