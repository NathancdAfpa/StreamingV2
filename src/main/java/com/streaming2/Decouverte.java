package com.streaming2;

public class Decouverte {

    private int playlist;
    private boolean filmRegarde;

    public Decouverte(int playlist, boolean filmRegarde) {
        this.playlist = playlist;
        this.filmRegarde = filmRegarde;
    }

    public int getPlaylist() {
        return playlist;
    }

    public void setPlaylist(int playlist) {
        this.playlist = playlist;
    }

    public boolean isFilmRegarde() {
        return filmRegarde;
    }

    public void setFilmRegarde(boolean filmRegarde) {
        this.filmRegarde = filmRegarde;
    }

/*    public int countFilm(int count){
        int compteur = 0;
        compteur++;
        if(compteur == 1){

        }
        return
    }*/
}
