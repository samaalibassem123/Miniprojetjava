package services;

import models.document.Document;
import models.user.Utilisateur;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserService {
    //RECHERCHE
    public static Boolean RechercheUserById(LinkedList<Utilisateur> tab, int id){
        for (Utilisateur user : tab ){
            if (user.getId() == id){
                return true;
            }
        }
        return false;
    }
    public static Boolean RechercheUserById(LinkedList<Utilisateur> tab, int id, String passw){
        for (Utilisateur user : tab ){
            if (user.getId() == id && user.getPassword().equals(passw)){
                return true;
            }
        }
        return false;
    }

    public static Boolean RechercheByTeacherRole(LinkedList<Utilisateur> tab, int id, String password){
        for (Utilisateur user : tab ){
            if (user.getId() == id && user.getPassword().equals(password) && user.getRole() == 'T'){
                return true;
            }
        }
        return false;
    }

    //AJOUTER
    public static void AjouterUser(Utilisateur user, LinkedList<Utilisateur> tab){
        tab.add(user);
        System.out.println("Utilisateur a ete ajouter avec Succer :)");
    }
    //AFFICHER
    public static void AfficheUsers(LinkedList<Utilisateur> tab){
        for (Utilisateur user : tab){
            System.out.println(user);
        }
    }
}
