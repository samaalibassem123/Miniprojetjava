package services;

import ErrorHandler.RetourInvalideException;
import models.document.Document;
import models.emprunt.Emprunt;
import models.user.Utilisateur;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

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

    //AJOUT
    public static void AjouterEmprumpt(ArrayList<Emprunt> tab, Utilisateur user, Document doc){
        if (user.EmprunterDocument(doc)){
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String text = "Emprunt";
            //CRERE OBJET EMPRUNT
            Emprunt e = new Emprunt(date, text, user, doc);
            //AJOUTE L'OBJET AU TABLEAU
            tab.add(e);
            System.out.println("EMPRUNT AJOUT AVEC SUCCER !!");
        }
    }
    public static void AjoutRetour(ArrayList<Emprunt> tab, Utilisateur user, Document doc){
        user.RetournezDocument(doc);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String text = "Retour";
        //CRERE OBJET EMPRUNT
        Emprunt e = new Emprunt(date, text, user, doc);
        //AJOUTE L'OBJET AU TABLEAU
        tab.add(e);
        System.out.println("RETOUR AJOUT AVEC SUCCER !!");
    }
    //RETOURNEZ
    public static void RetourDoc(ArrayList<Document> tabDoc ,LinkedList<Utilisateur> TabUser, ArrayList<Emprunt> tab, String idDoc, int idUser){
        Emprunt last_histo = null;
        for (Emprunt histo : tab){
            if (histo.getUser().getId() == idUser){
                if(histo.getDoc().getId().equals(idDoc)){
                    last_histo = histo;
                }
            }
        }
        try {
        if (last_histo == null){
            throw new RetourInvalideException();
        }else if(last_histo.getText().equals("Retour")){
            System.out.println("tu a deja le routorunez !!");
        }else if (last_histo.getText().equals("Emprunt")){
            //GET USER
            Utilisateur USER = UserService.GetUserById(TabUser, idUser);
            //GET DOC
            Document DOC = DocService.GetDocByID(tabDoc, idDoc);
            //RETOURNEZ LE DOC
            EmpruntService.AjoutRetour(tab, USER, DOC);
            System.out.println("ReTour Avec Succes !!");
        }
        }catch (RetourInvalideException e){
            System.out.println(e);
        }

    }
    //afichage
    public static void AfficheEmprunt(ArrayList<Emprunt> tab, int id){
        if (tab.size() == 0){
            System.out.println("-------->>>>>TAB USER EMPTY<<<<<--------");
        }else {
            System.out.println("-------->>>>>TAB HISTORIQUE DES EMPRUNTS<<<<<--------");
            for (Emprunt e : tab){
                if (e.getUser().getId() == id){
                    System.out.println(e);
                }
            }
            System.out.println("-------->>>>>FIN<<<<<--------");
        }

    }



}
