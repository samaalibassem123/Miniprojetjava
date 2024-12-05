package models.document;

public class Magasine extends Document {
    private int numeroEdition;

    public Magasine(String titre, String auteur, Boolean disponible, int numeroEdition) {
        super(titre, auteur, disponible);
        this.numeroEdition = numeroEdition;
    }

    public int getNumeroEdition() {
        return numeroEdition;
    }

    public void setNumeroEdition(int numeroEdition) {
        this.numeroEdition = numeroEdition;
    }

    @Override
    public String toString() {
        return super.toString()+" ==> Magasine{" +
                "numeroEdition=" + numeroEdition +
                '}';
    }
}
