package com.example.DAO;

import com.example.Module.Client;

import java.util.List;

public interface ClientDAO {
    public void insertClient(int id, String numeroCompte, String typeCompte, String solde);
    public void updateClient(int id, String numeroCompte, String typeCompte, String solde);
    public Client selectClient(int id);
    public List<Client> getAllClient();
    public void deleteClient(int id);
}
