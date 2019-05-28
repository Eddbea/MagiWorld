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
}
