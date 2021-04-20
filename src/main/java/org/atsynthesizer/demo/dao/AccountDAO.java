package com.example.demo.dao;

import com.example.demo.entity.Account;

import java.util.List;

public interface AccountDAO {
    public List<Account> allAccounts(int page);

    int accountsCount();

    public void add(Account account);


    public void delete(Account account);


    public void edit(Account account);


    public Account getById(int id);
}
