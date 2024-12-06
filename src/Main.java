import models.document.Document;
import models.document.Livre;
import models.document.Magasine;
import models.emprunt.Emprunt;
import models.user.Etudiant;
import models.user.Professeur;
import models.user.Utilisateur;
import services.DocService;
import services.EmpruntService;
import services.UserService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    //DATABASE
    static ArrayList<Emprunt> tabHisto = new ArrayList<Emprunt>();
    static ArrayList<Document> tabDocs = new ArrayList<Document>();
    static LinkedList<Utilisateur> tabUser = new LinkedList<Utilisateur>();
    //Main methods

    // 1) Affichage de Menu Principale
    public static void MenuPrincipale(){
            System.out.println("1. Ajout et Affiche des Documents \n" +
                    "2. Ajout et Affiche d'utilisateur \n" +
                    "3. Emprunt et Retour de Document \n" +
                    "4. Affichage de l'historique des emprunts \n" +
                    "0. Quitter");
            System.out.print("CHOISIR = ");
    }

    // 1.1) Menu des Documents
    public static void MenuDocs(){
        System.out.println("1. Ajouter Un Document \n" +
                "2. Affiche Un Document \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }
    public static void ExecuteDocs(int n){
        if (n != 0){
            Scanner sc = new Scanner(System.in);
            //AUTENTICATION
            System.out.println("---------LOGIN---------");
            System.out.print("ID = ");
            int ID = sc.nextInt();
            sc.nextLine();
            System.out.print("PASSWORD = ");
            String PASSWORD = sc.nextLine();
            if (!UserService.RechercheUserById(tabUser, ID, PASSWORD) && (ID != 0 || !PASSWORD.equals("ADMIN"))){
                System.out.println("User Id ou mot passe est incorrect !!");
            }else if (!UserService.RechercheByTeacherRole(tabUser, ID, PASSWORD) && (ID != 0 && !PASSWORD.equals("ADMIN")) ){
                System.out.println("tu n'a pas le droit d'acces");
            }else {
                switch (n){
                    case 1:
                        String id;
                        //CHECK IF THE ID IS ALREADU EXISTS
                        do {
                            System.out.print("---Donnez l'Id de Documents : ");
                            id = sc.nextLine();
                            if(DocService.RechercheDocument(tabDocs, id)){
                                System.out.println("Id deja utiliser");
                            }
                        }while (DocService.RechercheDocument(tabDocs, id));
                        sc.nextLine();

                        System.out.print("---donnez le titre: ");
                        String titre = sc.nextLine();
                        sc.nextLine();

                        System.out.print("---donnez le nom d'auteur: ");
                        String AutNom = sc.nextLine();

                        //CHOISR LE TYPE DE DOCUMENT
                        int answer;
                        do {
                            System.out.print("---1/Livre ou 2/Magazine: ");
                            answer = sc.nextInt();

                            switch (answer){
                                case 1:
                                    System.out.print("donnez le nombre de page de livre : ");
                                    int nbp = sc.nextInt();
                                    Document livre =new Livre(id, titre, AutNom, true,nbp);
                                    DocService.AjouterDocument(livre, tabDocs);
                                    break;
                                case 2:
                                    System.out.print("donnez le numero d'edition : ");
                                    int nedition = sc.nextInt();
                                    Document magazine =new Magasine(id, titre, AutNom, true,nedition);
                                    DocService.AjouterDocument(magazine, tabDocs);
                                    break;
                                default:
                                    System.out.println("Entrez 1 ou 2");
                                    break;
                            }
                        }while (answer != 1 && answer != 2);
                        break;
                    case 2:
                        DocService.AfficheDocs(tabDocs);
                        break;
                    default:
                        System.out.println("Entrez un Numbre Comme la liste vous indique !!");
                        break;
                }
            }
        }
        }



    // 1.2)Menu des utilisateur
    public static void MenuUser(){
        System.out.println("1. Ajouter Un Utilisateur \n" +
                "2. Affiche Un Utilisateur \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }
    public static void ExecuteUsers(int n){
        Scanner sc = new Scanner(System.in);
        switch (n){
            case 1:
                //CREER UN UTILISATEUR
                int id;
                do {
                    System.out.print("Donnez Votre ID: ");
                    id = sc.nextInt();
                    if (UserService.RechercheUserById(tabUser, id) || id == 0){
                        System.out.println("ID est Deja Utiliser !! ");
                    }
                }while (UserService.RechercheUserById(tabUser, id) || id == 0);

                System.out.print("Donnez Votre Nom: ");
                String name = sc.nextLine();
                sc.nextLine();

                sc.nextLine();
                System.out.print("Donnez Votre Password : ");
                String Password = sc.nextLine();

                sc.nextLine();
                //ROLE
                char role;
                do {
                    System.out.print("Choisir Le Role Etudiant:E Professeur:T = ");
                    String role_input = sc.nextLine();
                    role = role_input.charAt(0);

                    switch (role){
                        case 'E':
                            sc.nextLine();
                            System.out.print("Donnez Votre Niveau : ");
                            String niv = sc.nextLine();
                            Utilisateur etudiant = new Etudiant(name,id,Password,role,niv);
                            UserService.AjouterUser(etudiant, tabUser);
                            break;
                        case 'T':
                            sc.nextLine();
                            System.out.print("Donnez Votre Specialiter: ");
                            String spec = sc.nextLine();
                            Utilisateur Professeur = new Professeur(name,id,Password,role,spec);
                            UserService.AjouterUser(Professeur, tabUser);
                        default:
                            System.out.println("Slectionnz E ou T");
                    }
                }while (role != 'E' && role != 'T');
                break;
            case 2:
                UserService.AfficheUsers(tabUser);
                break;
            case 0:
                break;
            default:
                System.out.println("Entrez un Nombre Entre 1 et 2");
                break;

        }
    }

    // 1.3)Menu des utilisateur
    public static void MenuEmprunt(){
        System.out.println("1. Emprunter Un Document \n" +
                "2.  Routournez Un Document \n" +
                "0. Retournez");
        System.out.print("CHOISIR = ");
    }
    public static void ExecuteEmprunt(int n){
        if(n != 0){
            Scanner sc = new Scanner(System.in);
            //AUTENTICATION
            System.out.println("---------LOGIN---------");
            System.out.print("ID = ");
            int ID = sc.nextInt();
            sc.nextLine();
            System.out.print("PASSWORD = ");
            String PASSWORD = sc.nextLine();
            if (!UserService.RechercheUserById(tabUser, ID, PASSWORD) && ID == 0){
                System.out.println("User Id ou mot passe est incorrect !!");
            }else {
                switch (n){
                    case 1:
                        //EMPRUNT
                        //check if 
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("entrez un nombre 1 ou 2");
                        break;
                }
            }




        }
    }




    public static void main(String[] args) {

        Boolean stop = false;
        do {
            try{
                //MENU PRINCIPALE
                Main.MenuPrincipale();
                //INPUT DE CHOIX
                Scanner sc = new Scanner(System.in);
                int reponse = sc.nextInt();

                switch (reponse){
                    case 0:
                        stop = true;
                        break;
                    case 1:
                        int reponse1;
                        do {
                            //MENU DES DOCUMENTS
                            Main.MenuDocs();
                            //INPUT DE CHOIX
                            reponse1 = sc.nextInt();
                            Main.ExecuteDocs(reponse1);
                        }while (reponse1 != 0);
                        break;
                    case 2:
                        int reponse2;
                        do {
                            //MENU DES ULITILISATEURS
                            Main.MenuUser();
                            //INPUT DE CHOIX
                            reponse2 = sc.nextInt();
                            Main.ExecuteUsers(reponse2);
                        }while (reponse2 != 0);
                        break;
                    case 3:
                        int reponse3;
                        do {
                            //MENU DES EMPRUNTS
                            Main.MenuEmprunt();
                            //INPUT DE CHOIX
                            reponse3 = sc.nextInt();
                            Main.ExecuteUsers(reponse3);
                        }while (reponse3 != 0);
                        break;
                    case 4:
                        //AFFICHAGE DES EMPRUNTS
                        EmpruntService.AfficheEmprunt(tabHisto);
                        break;

                    default:
                        System.out.println("TAPPEZ UN NOMBRE COMME LA LISTE INDIQUE");
                        break;
                }


            }catch (Exception e){
                System.out.println("!!!!!! INVALID INPUT !!!!!!");
            }
        }while (!stop);

    }
}