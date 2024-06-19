package fr.TPI_INF4063;

import java.util.Random;
import java.util.Scanner;

public class SerpentsEtEchelles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de joueurs : ");
        int nombreDeJoueurs = scanner.nextInt();

        if (nombreDeJoueurs < 1 || nombreDeJoueurs > 6) {
            System.out.println("Le nombre de joueurs doit être entre 1 et 6.");
            return;
        }

        jouer(nombreDeJoueurs);
    }

    public static void jouer(int nombreDeJoueurs) {
        TableauDeJeu tableau = new TableauDeJeu();
        CircularlyLinkedList<Joueur> joueurs = new CircularlyLinkedList<>();
        boolean finDePartie = false;
        Joueur joueurCourant;

        // Ajouter les joueurs à la liste chaînée
        for (int i = 0; i < nombreDeJoueurs; i++) {
            joueurs.addLast(new Joueur());
        }

        // Initialiser le joueur courant en fonction de la liste chaînée des joueurs
        joueurCourant = joueurs.first();

        // Tant qu'aucun joueur n'atteint la case 99, la boucle principale du jeu fait avancer le joueur courant
        while (!finDePartie) {
            System.out.println("Tour de " + joueurCourant.getNom());

            int de = rouleLeDe(); // Lancer le dé pour obtenir un nombre aléatoire entre 1 et 6

            // Faites avancer le joueur courant en fonction du résultat du dé
            int nouvellePosition = joueurCourant.getPosition() + de;

            // Si le joueur tombe sur un serpent ou une échelle, suivez-la en utilisant la méthode correspondante de la tuile
            Tuile tuile = tableau.getTuile(nouvellePosition);
            if (tuile != null && tuile.isType()) {
                nouvellePosition = tuile.getDestination();
            }

            joueurCourant.setPosition(nouvellePosition);

            System.out.println("Le joueur " + joueurCourant.getNom() + " a atteint la tuile " + joueurCourant.getPosition());

            // Vérifiez si le joueur a atteint ou dépassé la case 99 pour mettre fin à la partie
            if (joueurCourant.getPosition() >= 99) {
                finDePartie = true;
            }

            // Passez au joueur suivant dans la liste chaînée
            joueurs.rotate();
            joueurCourant = joueurs.first();
        }

        System.out.println("Le joueur " + joueurCourant.getNom() + " a gagné");
    }

    // Retourne un nombre entre 1 et 6 (inclusivement) de manière équiprobable
    public static int rouleLeDe() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}




