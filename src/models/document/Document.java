package models.document;

import ErrorHandler.DocumentIndisponibleException;
import Interfaces.Operation;

public class Document{
    private String titre, auteur;
    private Boolean disponible;

    public Document(String titre, String auteur, Boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = disponible;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Document{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
