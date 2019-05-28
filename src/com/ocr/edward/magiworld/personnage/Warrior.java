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

    public void SimpleAttack(Personnage opponent) {

    }
}
