import java.util.Scanner;

public class Main {

    //Main methods

    // 1) Affichage de Menu Principale
    public static void MenuPrincipale(){
            System.out.println("1. Ajout et Affiche des Documents \n" +
                    "2. Ajout et Affiche d'utilisateur \n" +
                    "3. Emprunt et Retour de Document \n " +
                    "4. Affichage de l'historique des emprunts \n" +
                    "0. Quitter");
            System.out.print("CHOISIR = ");
    }

    // 1.1) Affichage de Menu des Documents
    public static void MenuDocs(){
        System.out.println("1. Ajouter Un Document \n" +
                "2. Affiche Un Document \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }

    // 1.2) Affichage de Menu des utilisateur
    public static void MenuUser(){
        System.out.println("1. Ajouter Un Utilisateur \n" +
                "2. Affiche Un Utilisateur \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }

    // 1.3) Affichage de Menu des utilisateur
    public static void MenuEmprunt(){
        System.out.println("1. Emprunter Un Document \n" +
                "2.  Routournez Un Utilisateur \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }





    public static void main(String[] args) {

    }
}