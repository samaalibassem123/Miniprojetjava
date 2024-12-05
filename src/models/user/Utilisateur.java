package models.user;

import ErrorHandler.DocumentIndisponibleException;
import Interfaces.Operation;
import models.document.Document;

public class Utilisateur implements Operation {
    private String nom;
    private int id;

    public Utilisateur(String nom, int id) {
        this.nom = nom;
        this.id = id;
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
