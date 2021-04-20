package com.example.demo.dao.hibernate;

import com.example.demo.dao.TownDAO;
import com.example.demo.entity.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TownDAOImpl implements TownDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Town> allTowns() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Town>)session.createQuery("from Town").list();
    }

    @Override
    public int townsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Town", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Town town) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(town);
    }

    @Override
    public void delete(Town town) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(town);
    }

    @Override
    public void edit(Town town) {
        Session session = sessionFactory.getCurrentSession();
        session.update(town);
    }

    @Override
    public Town getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Town.class, id);
    }
}
