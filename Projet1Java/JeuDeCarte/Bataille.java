package JeuDeCarte;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Bataille {
    public static void main(String[] args) {
        // Définition des formes , valeurs et des couleurs 
        String[] Formes = { "Coeur", "Trèfle","Carreau", "Pique" };
        String[] couleurs = { "rouge", "noir" };
        int[] valeurs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        // Création d'une liste pour stocker les cartes du jeu
        List<Carte> jeuDeCartes = new ArrayList<>();

        // Génération du jeu de cartes en combinant les formes, les couleurs et les valeurs
        for (int i = 0; i < Formes.length; i++) {
            for (int valeur : valeurs) {
                if (i% 2 ==0){
                    //Génération du jeu de cartes rouge(coeur et carreau)
                    jeuDeCartes.add(new Carte(Formes[i], couleurs[0], valeur));
                }else{
                    //Génération du jeu de cartes noirpique et trèfle)
                    jeuDeCartes.add(new Carte(Formes[i], couleurs[1], valeur));
                }
            }
            
        }
        //voir le nombre de cartes et les cartes
        /*System.out.println(jeuDeCartes);
        System.out.println(jeuDeCartes.size());*/

        // Mélange aléatoire du paquet de cartes
        Collections.shuffle(jeuDeCartes);

        // Création de deux joueurs
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        // Diviser le paquet de cartes en deux moitiés
        int tailleMoitie = jeuDeCartes.size() / 2;
        joueur1.main.addAll(jeuDeCartes.subList(0, tailleMoitie)); // Moitié de cartes pour le joueur 1
        joueur2.main.addAll(jeuDeCartes.subList(tailleMoitie, jeuDeCartes.size())); // Moitié de cartes pour le joueur 2

        // nombre de manche en fonction du nombre de cartes du joueur1
        int nombreDeManches = joueur1.main.size(); 

        //initialisation  du nombre de victoires des joueurs
        int victoiresJoueur1 = 0;
        int victoiresJoueur2 = 0;

        // Boucle pour jouer les manches
        for (int manche = 1; manche <= nombreDeManches; manche++) {
            Carte carteJoueur1 = joueur1.tirerUneCarte();
            Carte carteJoueur2 = joueur2.tirerUneCarte();

            System.out.println("Manche " + manche);
            System.out.println("Joueur 1 : " + carteJoueur1);
            System.out.println("Joueur 2 : " + carteJoueur2);

            if (carteJoueur1.getNumCarte() > carteJoueur2.getNumCarte()) {
                joueur1.incrementerCompteurPoints();
                System.out.println("Joueur 1 gagne la manche!");
                victoiresJoueur1++;
            } else if (carteJoueur2.getNumCarte() > carteJoueur1.getNumCarte()) {
                joueur2.incrementerCompteurPoints();
                System.out.println("Joueur 2 gagne la manche!");
                victoiresJoueur2++;
            } else {
                System.out.println("Égalité !");
            }
            System.out.println("Victoires Joueur 1 : " + victoiresJoueur1);
            System.out.println("Victoires Joueur 2 : " + victoiresJoueur2);
            System.out.println();
        }

        // Affichage des scores finaux
        System.out.println("Scores finaux :");
        System.out.println("Joueur 1 : " + joueur1.getCompteurPoints());
        System.out.println("Joueur 2 : " + joueur2.getCompteurPoints());

        // Détermination du vainqueur de la partie
        if (victoiresJoueur1 > victoiresJoueur2) {
            System.out.println("Joueur 1 gagne la partie!");
        } else if (victoiresJoueur2 > victoiresJoueur1) {
            System.out.println("Joueur 2 gagne la partie!");
        } else {
            System.out.println("La partie se termine par une égalité!");
        }
    }
}
