package models.document;

public class Livre extends Document {
    private int nombrePages;

    public Livre(String id, String titre, String auteur, Boolean disponible, int nombrePages) {
        super(id,titre, auteur, disponible);
        this.nombrePages = nombrePages;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    @Override
    public String toString() {
        return super.toString()+" ==> Livre{" +
                "nombrePages=" + nombrePages +
                '}';
    }
}
