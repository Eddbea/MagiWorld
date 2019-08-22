package com.ocr.edward.magiworld.jeu;

import com.ocr.edward.magiworld.personnage.Character;

import java.util.Scanner;

public class Duel {

    Character[] joueurs = new Character[2];

    //Lancement du duel
    public Duel(Character joueur1, Character joueur2) {
        this.joueurs[0] = joueur1;
        this.joueurs[1] = joueur2;
    }

    public void start(Scanner scan) {
        // Presentation des personnages
        Character joueur1 = joueurs[0];
        Character joueur2 = joueurs[1];

        System.out.println(joueur1.presentation());
        System.out.println("Versus");
        System.out.println(joueur2.presentation());

        // Round de combat -- tant les personnages sont vivants
        int roundCounter = 1;
        while (joueur1.isAlive() && joueur2.isAlive()) {
            System.out.println("Debut du round " + roundCounter);
            play(scan, joueur1, joueur2);
            play(scan, joueur2, joueur1);

            // fin de round ; on affiche l'etat des personnages.
            System.out.println("Debut du round " + roundCounter);
            System.out.println("Joueur 1 : " + joueurs[0].toString());
            System.out.println("Joueur 2 : " + joueurs[1].toString());
            roundCounter++;
        }
        if (joueur1.isAlive()) {
            System.out.println(joueur2.getName() + " a perdu");
        }
        if (joueur2.isAlive()) {
            System.out.println(joueur1.getName() + " a perdu");
        }
    }

    private void play(Scanner scan, Character currentPlayer, Character currentOpponnent) {
        // si le joueur est encore vivant
        if (currentPlayer.isAlive()) {
            // recuperer l'action joueur
            int actionDemandeeJ1 = actionDemandee(scan, currentPlayer);
            // jouer action demandee joueur
            jouerAction(actionDemandeeJ1, currentPlayer, currentOpponnent);
        }
    }

    //Attaque simple ou attaque speciale
    private void jouerAction(int actionDemandee, Character currentPlayer, Character currentOpponnent) {
        if (actionDemandee == 1) {
            currentPlayer.attaqueSimple(currentOpponnent);
        }
        if (actionDemandee == 2) {
            currentPlayer.attaqueSpeciale(currentOpponnent);
        }
    }

    /**
     * Choix de l'attaque et controle de saisie correcte
     * @param scan saisie de l'attaque 1 ou 2
     * @param currentPlayer de l'attaque choisie
     * @return
     */
    public int actionDemandee(Scanner scan, Character currentPlayer) {
        int action = -1;

        System.out.println("==============================================================");
        System.out.println("Tour du joueur " + currentPlayer.getName());
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
