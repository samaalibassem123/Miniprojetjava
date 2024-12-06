package models.user;

public class Etudiant extends Utilisateur{
    private String niveau;

    public Etudiant(String nom, int id, String password, char role, String niveau) {
        super(nom, id, password, role);
        this.niveau = niveau;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return super.toString() + " ==> Etudiant{" +
                "niveau='" + niveau + '\'' +
                '}';
    }
}
