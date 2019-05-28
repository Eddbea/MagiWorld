package com.ocr.edward.magiworld.jeu;

import com.ocr.edward.magiworld.personnage.Personnage;

import java.util.Scanner;

public class Duel {

    Personnage joueur1;
    Personnage joueur2;

    public Duel(Personnage joueur1, Personnage joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void start(Scanner scan) {
        // Presentation des persos
        System.out.println(joueur1.presentation());
        System.out.println("Versus");
        System.out.println(joueur2.presentation());

    }
}
