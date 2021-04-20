package com.example.demo.dao.hibernate;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Account> allAccounts(int page) {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Account>)session.createQuery("from Account").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public int accountsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Account", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(account);
    }

    @Override
    public void delete(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
    }

    @Override
    public void edit(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
    }

    @Override
    public Account getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, id);
    }
}
