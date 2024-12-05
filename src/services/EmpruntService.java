package services;

import models.emprunt.Emprunt;
import java.util.ArrayList;

public class EmpruntService {
    //ajouter
    public static void AjouterEmprumpt(ArrayList<Emprunt> tab, Emprunt e){
        tab.add(e);
    }
    //afichage
    public static void AfficheEmprunt(ArrayList<Emprunt> tab){
        for (Emprunt e : tab){
            System.out.println(e);
        }
    }



}
