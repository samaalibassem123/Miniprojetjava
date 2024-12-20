package user;

public class Professeur extends Utilisateur{
    private String specialiter;

    public Professeur(String nom, int id, String specialiter) {
        super(nom, id );
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
