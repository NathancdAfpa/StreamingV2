package fr.afpa.model;

public class Compte {

    private String type;

    public Compte(String type)
    {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
