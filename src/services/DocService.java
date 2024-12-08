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
    public static Document GetDocByID(ArrayList<Document> tab, String id){
        for (Document docs : tab ){
            if (docs.getId().equals(id)){
                return docs;
            }
        }
        return null;
    }

    //ajouter
    public static void AjouterDocument(Document doc, ArrayList<Document> tab){
            tab.add(doc);
            System.out.println("--------->>>>>Document a ete ajouter avec Succer :)");
    }
    //afficher
    public static void AfficheDocs(ArrayList<Document> tab){
        if (tab.size() == 0){
            System.out.println("-------->>>>>TAB USER EMPTY<<<<<--------");
        }else {
            System.out.println("-------->>>>>TAB DES DOCUMENTS<<<<<--------");
            for (Document doc : tab){
                System.out.println(doc);
            }
            System.out.println("-------->>>>>FIN<<<<<--------");
        }

    }
}
