package com.example.demo.dao.hibernate;

import com.example.demo.dao.DisabilityDAO;
import com.example.demo.entity.Disability;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisabilityDAOImpl implements DisabilityDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Disability> allDisabilities() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Disability>)session.createQuery("from Disability").list();
    }

    @Override
    public int disabilitiesCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Disability", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Disability disability) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(disability);
    }

    @Override
    public void delete(Disability disability) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(disability);
    }

    @Override
    public void edit(Disability disability) {
        Session session = sessionFactory.getCurrentSession();
        session.update(disability);
    }

    @Override
    public Disability getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Disability.class, id);
    }
}
