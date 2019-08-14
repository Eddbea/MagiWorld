package com.ocr.edward.magiworld.personnage;

public class Prowler extends Character {

    public Prowler(String name, int level, int strength, int dexterity, int intelligence) {
        super(name, level, strength, dexterity, intelligence);
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
    public void attaqueSimple(Character opponent) {
        double degats = getDexterity();
        System.out.println(name + " utilise Tir a l'arc et inflige " + degats + " degats");
        opponent.setLife(opponent.getLife() - degats);

    }

    @Override
    public void attaqueSpeciale(Character opponent) {
        double augmentationDex = (getLevel() / 2);
        System.out.println(name + " utilise Concentration et sa dexterite augmente de " + augmentationDex);
        setDexterity(augmentationDex + getDexterity());
    }

    public static String img = String.join("\n",
            "                              |''||''| '||               '||'''|,                          '||`  ",
            "                                  ||     ||                ||   ||                           ||   ",
            "                                  ||     ||''|, .|''|,     ||...|' '||''| .|''|, '\\    //`  ||  .|''|, '||''| ",
            "                                  ||     ||  || ||..||     ||       ||    ||  ||   \\\\//    ||  ||..||  ||    ",
            "                                 .||.   .||  || `|...     .||      .||.   `|..|'    \\\\    .||. `|...  .||.   ");

}
