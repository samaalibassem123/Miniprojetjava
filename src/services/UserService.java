package services;

import models.document.Document;
import models.user.Utilisateur;

import java.rmi.server.UID;
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
}
