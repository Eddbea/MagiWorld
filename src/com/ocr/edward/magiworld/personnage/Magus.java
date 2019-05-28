package com.ocr.edward.magiworld.personnage;

public class Magus extends Personnage {

    public static String img = "Abracadabra !!!!!!!";

    public Magus(int level, int strength, int dexterity, int intelligence) {
        super(level, strength, dexterity, intelligence);
    }


    @Override
    public String presentation() {
        StringBuffer buff = new StringBuffer();
        buff.append(img).append("\n")
                .append("je suis un Mage \n")
                .append(this.toString());
        return buff.toString();
    }

    /*
        Attaque Basique - Boule de Feu : Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire.
        Attaque Spéciale - Soin : Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie.
        Attention, il ne peut pas avoir plus de vie qu’il n’en avait au départ.
     */
    @Override
    public void attaqueSimple(Personnage opponent) {
        double degats = getIntelligence();
        System.out.println("Boule de feu et inflige " + degats + " degats");
        opponent.setLife(getLife() - degats);

    }

    @Override
    public void attaqueSpeciale(Personnage opponent) {
        double soin = getIntelligence() * 2;
        double currentLife = getLife();
        double maxLife = getLevel() * 5;
        if ((currentLife + soin) >= maxLife) {
            setLife(maxLife);
        } else {
            setLife(currentLife + soin);
        }
        System.out.println("Soin et sa vie remonte a :" + getLife());

    }
}
