package user;

import ErrorHandler.DocumentIndisponibleException;
import Interfaces.Operation;
import document.Document;

import java.util.LinkedList;

public class Utilisateur implements Operation {
    private String nom;
    private int id;


    public Utilisateur(String nom, int id) {
        this.nom = nom;
        this.id = id;

    }

    // Emprunter Les Documents
    @Override
    public Boolean EmprunterDocument(Document doc) {
        try{
            if (!doc.getDisponible()){
                throw new DocumentIndisponibleException();
            }else {
                doc.setDisponible(false);
                System.out.println("DOCUMENT A ETE EMPRUNTER AVEC SUCCEZ !!");
                return true;
            }
        }catch (DocumentIndisponibleException e){
            System.out.println(e);
            return false;
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

    //RECHERCHE
    public static Boolean RechercheUserById(LinkedList<Utilisateur> tab, int id){
        for (Utilisateur user : tab ){
            if (user.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static Utilisateur GetUserById(LinkedList<Utilisateur> tab, int id){
        for (Utilisateur user : tab ){
            if (user.getId() == id ){
                return user;
            }
        }
        return null;
    }

    //AJOUTER
    public static void AjouterUser(Utilisateur user, LinkedList<Utilisateur> tab){
        tab.add(user);
        System.out.println("-------->>>>>Utilisateur a ete ajouter avec Succer :)");
    }

    //AFFICHER
    public static void AfficheUsers(LinkedList<Utilisateur> tab){
        if (tab.size() == 0){
            System.out.println("-------->>>>>TAB USER EMPTY<<<<<--------");
        }else{
            System.out.println("-------->>>>>TABLEAU D'UTILISATEUR<<<<<--------");
            for (Utilisateur user : tab){
                System.out.println(user);
            }
            System.out.println("-------->>>>>FIN<<<<<--------");
        }

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
