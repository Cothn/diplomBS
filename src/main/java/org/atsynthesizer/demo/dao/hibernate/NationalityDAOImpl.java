package com.example.demo.dao.hibernate;

import com.example.demo.dao.NationalityDAO;
import com.example.demo.entity.Nationality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NationalityDAOImpl implements NationalityDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Nationality> allNationalities() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Nationality>)session.createQuery("from Nationality").list();
    }

    @Override
    public int nationalitiesCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Nationality", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Nationality nationality) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(nationality);
    }

    @Override
    public void delete(Nationality nationality) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(nationality);
    }

    @Override
    public void edit(Nationality nationality) {
        Session session = sessionFactory.getCurrentSession();
        session.update(nationality);
    }

    @Override
    public Nationality getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Nationality.class, id);
    }
}
