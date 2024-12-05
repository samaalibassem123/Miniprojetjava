package services;

import models.document.Document;

import java.util.ArrayList;

public class DocService {
    //ajouter
    public static void AjouterDocument(Document doc, ArrayList<Document> tab){
        if (tab.contains(doc)){
            System.out.println("Document Deja Exite!!!");
        }else {
            tab.add(doc);
            System.out.println("Document a ete ajouter avec Succer :)");
        }
    }
    //afficher
    public static void AfficheDocs(ArrayList<Document> tab){
        for (Document doc : tab){
            System.out.println(doc);
        }
    }
}
