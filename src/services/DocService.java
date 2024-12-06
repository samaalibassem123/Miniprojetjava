package services;

import models.document.Document;

import java.util.ArrayList;

public class DocService {
    //recherche doc
    public static Boolean RechercheDocument(ArrayList<Document> tab, String id){
        for (Document docs : tab ){
            if (docs.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    //ajouter
    public static void AjouterDocument(Document doc, ArrayList<Document> tab){
            tab.add(doc);
            System.out.println("Document a ete ajouter avec Succer :)");
    }
    //afficher
    public static void AfficheDocs(ArrayList<Document> tab){
        for (Document doc : tab){
            System.out.println(doc);
        }
    }
}
