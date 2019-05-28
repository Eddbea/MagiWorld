package com.ocr.edward.magiworld.personnage;

public class Warrior extends Personnage {

    public static String img = "WOOOOOOOOOOOOOOOOO";

    public Warrior(int level, int strength, int dexterity, int intelligence) {
        super(level, strength, dexterity, intelligence);
    }

    @Override
    public String presentation() {
        StringBuffer buff = new StringBuffer();
        buff.append(img).append("\n")
                .append("je suis un guerrier \n")
                .append(this.toString());
        return buff.toString();
    }

    /*
    Attaque Basique - Coup d’Épée : Effectue des dommages égaux à la force du joueur sur l’adversaire.

    Attaque Spéciale - Coup de Rage : Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire.
     Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2.
     */

    @Override
    public void attaqueSimple(Personnage opponent) {
        int degats = getStrength();
        System.out.println("Coup d' epee et inflige " + degats + " degats");
        opponent.setLife(getLife() - degats);

    }

    @Override
    public void attaqueSpeciale(Personnage opponent) {
        int degats = getStrength() * 2;
        int diminutionDeForce = getStrength() / 2;
        setStrength(diminutionDeForce);
        System.out.println("Coup de Rage et inflige " + degats + " degats mais sa force devient " + diminutionDeForce);
        opponent.setLife(getLife() - degats);

    }

}
