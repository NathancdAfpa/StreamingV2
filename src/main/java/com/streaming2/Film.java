package com.streaming2;

import javafx.beans.value.ObservableValue;

import java.util.List;

public class Film {

    private String titre;
    private String dateSortie;
    private List<Acteur> listActeur;

    public Film(String titre, String dateSortie) {
        this.titre = titre;
        this.dateSortie = dateSortie;
    }

    public Film(String titre, String dateSortie, List<Acteur> listActeur) {
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.listActeur = listActeur;
    }

    public Film(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public List<Acteur> getListActeur() {
        return listActeur;
    }

    public void setListActeur(List<Acteur> listActeur) {
        this.listActeur = listActeur;
    }
}
