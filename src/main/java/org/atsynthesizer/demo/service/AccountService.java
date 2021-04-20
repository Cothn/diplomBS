package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> allAccounts(int page);

    int getAccountsCount();

    public void add(Account account);


    public void delete(Account account);


    public void edit(Account account);


    public Account getById(int id);
}
