package com.ocr.edward.magiworld.personnage;

public abstract class Personnage {

    protected int level;
    protected int life;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    public Personnage(int level, int strength, int dexterity, int intelligence) {
        this.level = level;
        this.life = level * 5;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public static boolean checkBeforeCreate(int level, int strength, int dexterity, int intelligence) {

        return (level == strength + dexterity + intelligence);
    }

    public abstract String presentation();

    @Override
    public String toString() {
        return "{" +
                "level=" + level +
                ", life=" + life +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                '}';
    }
}
