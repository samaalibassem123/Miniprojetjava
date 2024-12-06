package models.user;

public class Professeur extends Utilisateur{
    private String specialiter;

    public Professeur(String nom, int id, String password, char role, String specialiter) {
        super(nom, id, password, role);
        this.specialiter = specialiter;
    }

    public String getSpecialiter() {
        return specialiter;
    }

    public void setSpecialiter(String specialiter) {
        this.specialiter = specialiter;
    }

    @Override
    public String toString() {
        return super.toString()+" ==> Professeur{" +
                "specialiter='" + specialiter + '\'' +
                '}';
    }
}
