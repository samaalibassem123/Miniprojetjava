package emprunt;

import ErrorHandler.RetourInvalideException;
import document.Document;

import user.Utilisateur;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Emprunt {

    private String text;
    private Utilisateur user;
    private Document doc;

    public Emprunt(String text, Utilisateur user, Document doc) {

        this.text = text;
        this.user = user;
        this.doc = doc;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
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
            String text = "Emprunt";
            //CRERE OBJET EMPRUNT
            Emprunt e = new Emprunt(text, user, doc);
            //AJOUTE L'OBJET AU TABLEAU
            tab.add(e);
            System.out.println("EMPRUNT AJOUT AVEC SUCCER !!");
        }
    }
    public static void AjoutRetour(ArrayList<Emprunt> tab, Utilisateur user, Document doc){
        user.RetournezDocument(doc);
        String text = "Retour";
        //CRERE OBJET EMPRUNT
        Emprunt e = new Emprunt(text, user, doc);
        //AJOUTE L'OBJET AU TABLEAU
        tab.add(e);
        System.out.println("----------->>>RETOUR AJOUT AVEC SUCCER<<<------------");
    }
    //RETOURNEZ
    public static void RetourDoc(ArrayList<Document> tabDoc , LinkedList<Utilisateur> TabUser, ArrayList<Emprunt> tab, String idDoc, int idUser){
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
                Utilisateur USER = Utilisateur.GetUserById(TabUser, idUser);
                //GET DOC
                Document DOC = Document.GetDocByID(tabDoc, idDoc);
                //RETOURNEZ LE DOC
                Emprunt.AjoutRetour(tab, USER, DOC);

            }
        }catch (RetourInvalideException e){
            System.out.println(e);
        }

    }
    //afichage
    public static void AfficheEmprunt(ArrayList<Emprunt> tab, int id){
        if (tab.size() == 0){
            System.out.println("-------->>>>>TAB HISTO EMPTY<<<<<--------");
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
    @Override
    public String toString() {
        return "Emprunt{" +
                "text='" + text + '\'' +
                ", user=" + user +
                ", doc=" + doc +
                '}';
    }
}
