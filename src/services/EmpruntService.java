package services;

import models.emprunt.Emprunt;
import java.util.ArrayList;

public class EmpruntService {
    //RECHERCHE
    public static Boolean RechercheById(ArrayList<Emprunt> tab, int id){
        for (Emprunt histo : tab){
            if (histo.getUser().getId() == id){
                return true;
            }
        }
        return false;
    }
    //EMPRUNTER
    public static void AjouterEmprumpt(ArrayList<Emprunt> tab, Emprunt e){
        tab.add(e);
    }
    //RETOURNEZ
    //afichage
    public static void AfficheEmprunt(ArrayList<Emprunt> tab, int id){
        for (Emprunt e : tab){
            if (e.getUser().getId() == id){
                System.out.println(e);
            }
        }
    }



}
