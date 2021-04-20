package com.example.demo.dao.hibernate;

import com.example.demo.dao.FamilyStatusDAO;
import com.example.demo.entity.FamilyStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamilyStatusDAOImpl implements FamilyStatusDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<FamilyStatus> allFamilyStatuses() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<FamilyStatus>)session.createQuery("from FamilyStatus").list();
    }

    @Override
    public int familyStatusesCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from FamilyStatus", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(FamilyStatus familyStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(familyStatus);
    }

    @Override
    public void delete(FamilyStatus familyStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(familyStatus);
    }

    @Override
    public void edit(FamilyStatus familyStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.update(familyStatus);
    }

    @Override
    public FamilyStatus getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(FamilyStatus.class, id);
    }
}
