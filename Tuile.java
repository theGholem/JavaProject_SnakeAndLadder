package fr.TPI_INF4063;

public class Tuile {
    private int position;    // De 0 à 99, la position.
    private boolean type;    // false pour régulier, true pour serpent et/ou échelle
    private int destination; // 0 si c'est une tuile régulière ; autrement la destination du serpent ou de l'échelle

    public Tuile(int position) {
        this.position = position;
        this.type = false;
        this.destination = 0;
    }

    public int getPosition() {
        return position;
    }

    // Si une tuile est soit un serpent soit une échelle, on se sert de cette méthode pour fixer sa destination.
    public void makeSpecialType(int destination) {
        this.type = true;
        this.destination = destination;
    }

    public boolean isType() {
        return type;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
