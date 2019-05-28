package com.ocr.edward.magiworld;

import com.ocr.edward.magiworld.jeu.Duel;
import com.ocr.edward.magiworld.personnage.Magus;
import com.ocr.edward.magiworld.personnage.Personnage;
import com.ocr.edward.magiworld.personnage.Rogue;
import com.ocr.edward.magiworld.personnage.Warrior;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

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

    public static void main(String[] args) {
        // write your code here
        // phase 1 : creqtion des personnages
        System.out.println("Bienvenue sur Magiworld");
        System.out.println(rulesCreation);
        Personnage joueur1 = createJoueurFromSaisie(1);
        Personnage joueur2 = createJoueurFromSaisie(2);

        // phase 2 : creation du jeu
        Duel jeu = new Duel(joueur1, joueur2);
        jeu.start(scan);
        // fin du bal on remballe
    }

    private static Personnage createJoueurFromSaisie(int numeroJoueur) {
        System.out.println("Creation du personnage Joueur " + numeroJoueur);

        // Joueur 1
        boolean saisieOK = true;
        int classe, level, force, dex, inte = 0;

        do {
            classe = saisieClassePersonnage("Veuillez choisir la classe du personnage (1: Guerrier, 2: Voleur, 3: Mage)", scan);
            level = saisiePersonnage("Niveau du personnage Joueur " + numeroJoueur + " ?", scan);
            force = saisiePersonnage("Force du personnage Joueur " + numeroJoueur + " ?", scan);
            dex = saisiePersonnage("Dexterite du personnage Joueur " + numeroJoueur + " ?", scan);
            inte = saisiePersonnage("intelligence du personnage Joueur " + numeroJoueur + " ?", scan);

            saisieOK = Personnage.checkBeforeCreate(level, force, dex, inte);
            if (!saisieOK)
                System.out.println("Erreur de saisie : rappel des regles");
            System.out.println(rulesCreation);
        } while (!saisieOK);

        Personnage joueur = null;
        switch (classe) {
            case 1:
                joueur = new Warrior(level, force, dex, inte);
                break;
            case 2:
                joueur = new Rogue(level, force, dex, inte);
                break;
            case 3:
                joueur = new Magus(level, force, dex, inte);
                break;

        }
        return joueur;
    }

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
