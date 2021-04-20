package com.example.demo.dao;

import com.example.demo.entity.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> allClients(int page);
    List<Client> allClients();
    void add(Client client);
    void delete(Client client);
    void edit(Client client);
    Client getById(int id);
    int clientsCount() ;
}
