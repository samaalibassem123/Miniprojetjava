package models.emprunt;

import models.document.Document;
import models.user.Utilisateur;

import java.util.Date;

public class Emprunt {
    private Date date;
    private String text;
    private Utilisateur user;
    private Document doc;

    public Emprunt(Date date, String text, Utilisateur user, Document doc) {
        this.date = date;
        this.text = text;
        this.user = user;
        this.doc = doc;
    }

    public Emprunt(Date date, String text, Utilisateur user) {
        this.date = date;
        this.text = text;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "date=" + date +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", doc=" + doc +
                '}';
    }
}
