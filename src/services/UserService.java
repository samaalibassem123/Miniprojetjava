package services;

import models.user.Utilisateur;

import java.util.LinkedList;

public class UserService {
    //ajouter
    public static void AjouterUser(Utilisateur user, LinkedList<Utilisateur> tab){
        if (tab.contains(user)){
            System.out.println("User Deja Existe !!!");
        }else {
            tab.add(user);
            System.out.println("Utilisateur a ete ajouter avec Succer :)");
        }
    }
    //afficher
    public static void AfficheUsers(LinkedList<Utilisateur> tab){
        for (Utilisateur user : tab){
            System.out.println(user);
        }
    }
}
