package com.ocr.edward.magiworld.personnage;

public class Warrior extends Personnage {

    public static String img = "WOOOOOOOOOOOOOOOOO";

    public Warrior(String name, int level, int strength, int dexterity, int intelligence) {
        super(name, level, strength, dexterity, intelligence);
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
        double degats = getStrength();
        System.out.println(name + " utilise Coup d' epee et inflige " + degats + " degats");
        opponent.setLife(opponent.getLife() - degats);

    }

    @Override
    public void attaqueSpeciale(Personnage opponent) {
        double degats = getStrength() * 2;
        double diminutionDeVie = getStrength() / 2;

        System.out.println(name + " utilise Coup de Rage et inflige " + degats + " degats mais sa vie diminue de " + diminutionDeVie);
        opponent.setLife(opponent.getLife() - degats);
        setLife(getLife() - diminutionDeVie);


    }

}
