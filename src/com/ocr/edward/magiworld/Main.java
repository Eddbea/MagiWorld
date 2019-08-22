package com.ocr.edward.magiworld;

import com.ocr.edward.magiworld.jeu.Duel;
import com.ocr.edward.magiworld.personnage.Magus;
import com.ocr.edward.magiworld.personnage.Character;
import com.ocr.edward.magiworld.personnage.Prowler;
import com.ocr.edward.magiworld.personnage.Warrior;

import java.util.Scanner;

public class Main {

    //Creation d'un Scanner pour recuperer la saisie de l'utilisateur
    private static Scanner scan = new Scanner(System.in);

    //Affichage de la presentation et des regles du Jeu
    private static String rulesCreation = String.join("\n",
            "----------------------------------------------------------------------------------------",
            "* Chaque personnage possède 5 caractéristiques :                                       *",
            "* Niveau : choisi par le joueur (min 1, max 100)                                       *",
            "* Vie : égale au niveau du joueur * 5                                                  *",
            "* Force : choisie par le joueur (min 0, max 100)                                       *",
            "* Agilité : choisie par le joueur (min 0, max 100)                                     *",
            "* Intelligence : choisie par le joueur (min 0, max 100)                                *",
            "* Attention le total force + agilité + intelligence doit être égal au niveau du joueur.*",
            "----------------------------------------------------------------------------------------");

    // Creation des personnages et affichage des regles
    public static void main(String[] args) {

        System.out.println("Bienvenue sur Magiworld");
        System.out.println(rulesCreation);
        Character joueur1 = createJoueurFromSaisie(1);
        Character joueur2 = createJoueurFromSaisie(2);

        // creation du jeu
        Duel jeu = new Duel(joueur1, joueur2);
        jeu.start(scan);
    }


    /**
     * Creation des joueurs et controle de bonne saisie
     * @param numeroJoueur Attribution de numero de chaque joueur (1 et 2)
     * @return joueur Renvoi le joueur choisi
     */
    private static Character createJoueurFromSaisie(int numeroJoueur) {
        System.out.println("Creation du personnage Joueur " + numeroJoueur);
        String name = "Joueur " + numeroJoueur;

        // Joueur 1
        boolean saisieOK = true;
        int classe, level, strength, dexterity, intellect = 0;

        do {
            classe = saisieClassePersonnage("Veuillez choisir la classe du personnage (1: Guerrier, 2: Rodeur, 3: Mage)", scan);
            level = saisiePersonnage("Niveau du personnage Joueur " + numeroJoueur + " ?", scan);
            strength = saisiePersonnage("Force du personnage Joueur " + numeroJoueur + " ?", scan);
            dexterity = saisiePersonnage("Dexterite du personnage Joueur " + numeroJoueur + " ?", scan);
            intellect = saisiePersonnage("intelligence du personnage Joueur " + numeroJoueur + " ?", scan);

            saisieOK = Character.checkBeforeCreate(level, strength, dexterity, intellect);
            if (!saisieOK)
                System.out.println("Erreur de saisie : rappel des regles");
            System.out.println(rulesCreation);
        } while (!saisieOK);

        Character joueur = null;
        switch (classe) {
            case 1:
                joueur = new Warrior(name, level, strength, dexterity, intellect);
                break;
            case 2:
                joueur = new Prowler(name, level, strength, dexterity, intellect);
                break;
            case 3:
                joueur = new Magus(name, level, strength, dexterity, intellect);
                break;
        }
        return joueur;
    }

    /**
     * Controle de saisie correct d'un entier superieur a 0 pour le choix du personnage
     *
     * @param label choix de la classe
     * @param scan  recuperation de la saisie
     * @return saisie
     */
    private static int saisiePersonnage(String label, Scanner scan) {
        int retour = -1;
        while (retour == -1) {
            System.out.println(label);

            if (scan.hasNextInt()) {
                retour = scan.nextInt();

            } else {
                scan.next();
                System.out.println("Erreur de saisie : entier uniquement");
            }
        }
        return retour;

    }

    /**
     * Controle de saisie correct d'un entier superieur a 0 et compris entre 1 et 3 pour le choix du personnage
     * @param label choix de la classe
     * @param scan recuperation de la saisie
     * @return choix de la classe
     */
    private static int saisieClassePersonnage(String label, Scanner scan) {
        int retour = -1;
        while (retour == -1) {
            System.out.println(label);

            if (scan.hasNextInt()) {
                retour = scan.nextInt();
                if (retour < 0 || retour > 3) {
                    System.out.println("Erreur de saisie : class entre 1 et 3");
                    retour = -1;
                }
            } else {
                scan.next();
                System.out.println("Erreur de saisie : entier uniquement");
            }

        }
        return retour;

    }
}
