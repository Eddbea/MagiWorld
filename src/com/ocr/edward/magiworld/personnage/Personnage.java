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

    public abstract void attaqueSimple(Personnage opponent);

    public abstract void attaqueSpeciale(Personnage opponent);

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
