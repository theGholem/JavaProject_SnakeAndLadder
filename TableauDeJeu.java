package fr.TPI_INF4063;


public class TableauDeJeu {

    private Tuile[] tableau = new Tuile[100]; // Le tableau de jeu

    public TableauDeJeu() {
        for (int i = 0; i < 100; i++) {
            tableau[i] = new Tuile(i);
        }

        tableau[98].makeSpecialType(53);
        tableau[69].makeSpecialType(54);
        tableau[51].makeSpecialType(41);
        tableau[24].makeSpecialType(1);
        tableau[94].makeSpecialType(71);

        tableau[5].makeSpecialType(24);
        tableau[10].makeSpecialType(39);
        tableau[59].makeSpecialType(84);
        tableau[45].makeSpecialType(89);
        tableau[16].makeSpecialType(68);
    }

    public Tuile[] getTableau() {
        return tableau;
    }

    // Ajoutez cette méthode pour accéder à une tuile spécifique en fonction de sa position.
    public Tuile getTuile(int position) {
        if (position >= 0 && position < tableau.length) {
            return tableau[position];
        } else {
            // Gérez le cas où la position est invalide (en dehors des limites du tableau).
            return null; // Ou lancez une exception appropriée.
        }
    }
}





    