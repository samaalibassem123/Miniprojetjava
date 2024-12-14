package document;

import java.util.ArrayList;

public class Document{

    private String id,titre, auteur;
    private Boolean disponible;

    public Document(String id, String titre, String auteur, Boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = disponible;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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
            System.out.println("-------->>>>>TAB DOCS EMPTY<<<<<--------");
        }else {
            System.out.println("-------->>>>>TAB DES DOCUMENTS<<<<<--------");
            for (Document doc : tab){
                System.out.println(doc);
            }
            System.out.println("-------->>>>>FIN<<<<<--------");
        }

    }
    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
