package com.ocr.edward.magiworld.jeu;

import com.ocr.edward.magiworld.personnage.Personnage;

import java.util.Scanner;

public class Duel {

    Personnage[] joueurs = new Personnage[2];


    public Duel(Personnage joueur1, Personnage joueur2) {
        this.joueurs[0] = joueur1;
        this.joueurs[1] = joueur2;
    }

    public void start(Scanner scan) {
        // Presentation des persos
        System.out.println(joueurs[0].presentation());
        System.out.println("Versus");
        System.out.println(joueurs[1].presentation());
        // Round de combat -- tant les perso sont vivants
        // recuperer l'action joueur 1
        int actionDemandeeJ1 = actionDemandee(scan, 0);
        // jouer action demandee joueur 1
        jouerAction(actionDemandeeJ1, 0, 1);
        // recuperer l'action joueur 2
        int actionDemandeeJ2 = actionDemandee(scan, 1);
        // jouer action demandee joueur 2
        jouerAction(actionDemandeeJ2, 1, 0);
        // fin de round ; on affiche l'etat des perso.
        System.out.println("Joueur 1 : " + joueurs[0].toString());
        System.out.println("Joueur 2 : " + joueurs[1].toString());


    }

    private void jouerAction(int actionDemandee, int joueurIndex, int opponentIndex) {
        Personnage currentPlayer = joueurs[joueurIndex];
        Personnage currentOpponnent = joueurs[opponentIndex];
        System.out.print(" Joueur " + (joueurIndex + 1) + "utilise ");
        if (actionDemandee == 1) {
            currentPlayer.attaqueSimple(currentOpponnent);
        }
        if (actionDemandee == 2) {
            currentPlayer.attaqueSpeciale(currentOpponnent);
        }

    }

    public int actionDemandee(Scanner scan, int joueurIndex) {
        int action = -1;
        Personnage currentPlayer = joueurs[joueurIndex];
        System.out.println("Tour du joueur " + (joueurIndex + 1));
        System.out.println("Niveau de vie :" + currentPlayer.getLife());
        while (action == -1) {
            System.out.println("----------------------------ACTION-------");
            System.out.println(" 1 :-> attaque Simple");
            System.out.println(" 2 :-> attaque Speciale");

            if (scan.hasNextInt()) {
                action = scan.nextInt();
                if (action < 0 || action > 2) {
                    System.out.println("Erreur de saisie : action entre 1 et 2");
                    action = -1;
                }
            } else {
                scan.next();
                System.out.println("Erreur de saisie : entier uniquement");
            }
        }
        return action;
    }
}
