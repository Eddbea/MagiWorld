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

    public static String img = String.join("\n",
            "             _   _     _       __ ",
            "            | | | |   (_)     / _|",
            "            | |_| |__  _  ___| |_ ",
            "            | __| '_ \\| |/ _ \\  _|",
            "            | |_| | | | |  __/ |",
            "             \\__|_| |_|_|\\___|_|");


}
