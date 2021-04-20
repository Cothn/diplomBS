package com.example.demo.service.implementation;

import com.example.demo.dao.ClientDAO;
import com.example.demo.dao.hibernate.ClientDAOImpl;
import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    private ClientDAO clientDAO;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public List<Client> allClients(int page) {
        return clientDAO.allClients(page);
    }

    @Override
    @Transactional
    public int getClientsCount() {
        return clientDAO.clientsCount();
    }

    @Override
    @Transactional
    public void add(Client client) {
        clientDAO.add(client);
    }

    @Override
    @Transactional
    public boolean checkByPassport(Client client) {
        List<Client> clients = clientDAO.allClients();
        for (Client cl : clients){
            if(cl.getPassportSeries().equalsIgnoreCase(client.getPassportSeries()) &&
                    cl.getPassportNumber().equalsIgnoreCase(client.getPassportNumber()) &&
                            (cl.getId() != client.getId()))
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean checkByIdentifyNumber(Client client) {
        List<Client> clients = clientDAO.allClients();
        for (Client cl : clients){
            if(cl.getIdentificationNumber().equalsIgnoreCase(client.getIdentificationNumber()) &&
                (cl.getId() != client.getId()))
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    @Transactional
    public void edit(Client client) {
        clientDAO.edit(client);
    }

    @Override
    @Transactional
    public Client getById(int id) {
        return clientDAO.getById(id);
    }
}
