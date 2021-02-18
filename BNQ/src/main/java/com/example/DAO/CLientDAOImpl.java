package com.example.DAO;

import com.example.Connection.Conn;
import com.example.Module.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CLientDAOImpl implements ClientDAO{
    Client client;
    //insert client
    @Override
    public void insertClient(int id, String numeroCompte, String typeCompte, String solde) {
        try {
            Connection conn = Conn.getMyConnexion();
            String query = "INSERT INTO client (numerocompte, typecompte, solde) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, numeroCompte);
            preparedStatement.setString(2, typeCompte);
            preparedStatement.setString(3, solde);
            preparedStatement.executeUpdate();
            System.out.println("Creat Client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //update client
    @Override
    public void updateClient(int id, String numeroCompte, String typeCompte, String solde) {
        try {
            Connection conn  = Conn.getMyConnexion();
            String query = "UPDATE client  SET numerocompte=?, typecompte=?, solde=? WHERE id_client=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, numeroCompte);
            preparedStatement.setString(2, typeCompte);
            preparedStatement.setString(3, solde);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Client update");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //get by id
    @Override
    public Client selectClient(int id) {
        try {
            Connection conn = Conn.getMyConnexion();
            String query = "Select * From client Where id_client=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String numerocompte = resultSet.getString("numerocompte");
                String typecompte=resultSet.getString("typecompte");
                String solde=resultSet.getString("solde");
                client = new Client(id, solde, typecompte, numerocompte);
            }
            System.out.println("Client by id");
        }catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    //select Client
    @Override
    public List<Client> getAllClient() {
        List<Client> listClient = new ArrayList<>();
        try {
            Connection conn = Conn.getMyConnexion();
            String query = "SELECT * FROM client";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                client = new Client(rs.getInt("id_client"), rs.getString("solde"), rs.getString("typecompte"), rs.getString("numerocompte"));
                listClient.add(client);
            }
            System.out.println("list client");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listClient;

    }

    //delete cleint
    @Override
    public void deleteClient(int id) {
        try {
            Connection conn = Conn.getMyConnexion();
            String query = "DELETE FROM client WHERE id_client=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Client delete");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
