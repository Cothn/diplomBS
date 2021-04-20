package com.example.demo.dao.hibernate;

import com.example.demo.dao.ClientDAO;
import com.example.demo.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Client> allClients(int page) {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Client>)session.createQuery("from Client").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> allClients() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Client>)session.createQuery("from Client").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int clientsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Client", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }

    @Override
    public void delete(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }

    @Override
    public void edit(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    @Override
    public Client getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }
}
