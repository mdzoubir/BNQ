package com.example.Module;

public class Client {
    private int  id;
    private String numeroCompte;
    private String typeCompte;
    private String Solde;

    public Client() {
    }

    public Client(int id, String numeroCompte, String typeCompte, String solde) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        Solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getSolde() {
        return Solde;
    }

    public void setSolde(String solde) {
        Solde = solde;
    }
}
