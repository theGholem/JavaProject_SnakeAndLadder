package fr.TPI_INF4063;


public class Joueur {

    public static int compteurDeJoueurs = 0;
    private int nom;
    private int position;

    Joueur() {
        nom = compteurDeJoueurs;
        position = 0;
        compteurDeJoueurs++;
        System.out.println("Ajout du joueur " + nom);
    }

    public int getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


