package models.user;

import ErrorHandler.DocumentIndisponibleException;
import Interfaces.Operation;
import models.document.Document;

import javax.management.relation.Role;
import java.util.PrimitiveIterator;

public class Utilisateur implements Operation {
    private String nom;
    private int id;
    private String password;
    private char role;

    public Utilisateur(String nom, int id, String password, char role) {
        this.nom = nom;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    // Emprunter Les Documents
    @Override
    public void EmprunterDocument(Document doc) {
        try{
            if (!doc.getDisponible()){
                throw new DocumentIndisponibleException();
            }else {
                doc.setDisponible(false);
                System.out.println("DOCUMENT A ETE EMPRUNTER AVEC SUCCEZ !!");
            }
        }catch (DocumentIndisponibleException e){
            System.out.println(e);
        }
    }
    // Routournez Les Documents
    @Override
    public void RetournezDocument(Document doc) {
        doc.setDisponible(true);
        System.out.println("DOCUMENT A ETE ROUTOURNEZ");
    }

    //Getters And Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                ", role=" + role +
                '}';
    }
}
