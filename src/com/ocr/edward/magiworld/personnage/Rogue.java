package com.ocr.edward.magiworld.personnage;

public class Rogue extends Personnage {

    public Rogue(int level, int strength, int dexterity, int intelligence) {
        super(level, strength, dexterity, intelligence);
    }

    @Override
    public String presentation() {
        StringBuffer buff = new StringBuffer();
        buff.append(img).append("\n")
                .append("je suis un rodeur \n")
                .append(this.toString());
        return buff.toString();
    }
    /*
    Attaque Basique - Tir à l’Arc : Effectue des dommages égaux à l’agilité du joueur sur l’adversaire.
    Attaque Spéciale - Concentration : Le joueur gagne son niveau divisé par 2 en agilité.
    */

    @Override
    public void attaqueSimple(Personnage opponent) {
        double degats = getDexterity();
        System.out.println("Tir a l'arc et inflige " + degats + " degats");
        opponent.setLife(getLife() - degats);

    }

    @Override
    public void attaqueSpeciale(Personnage opponent) {
        double augmentationDex = (getLevel() / 2);
        System.out.println("Concentration et sa dexterite augmente de " + augmentationDex);
        setDexterity(augmentationDex + getDexterity());
    }

    public static String img = String.join("\n",
            "             _   _     _       __ ",
            "            | | | |   (_)     / _|",
            "            | |_| |__  _  ___| |_ ",
            "            | __| '_ \\| |/ _ \\  _|",
            "            | |_| | | | |  __/ |",
            "             \\__|_| |_|_|\\___|_|");


}
