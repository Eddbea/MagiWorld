package com.ocr.edward.magiworld.personnage;

public abstract class Character {

    protected int level;
    protected double life;
    protected double strength;
    protected double dexterity;
    protected double intelligence;
    protected String name;

    public Character(String name, int level, double strength, double dexterity, double intelligence) {
        this.name = name;
        this.level = level;
        this.life = level * 5;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public static boolean checkBeforeCreate(int level, double strength, double dexterity, double intelligence) {
        boolean goodLevelCoherence = (level == strength + dexterity + intelligence);
        boolean goodLevel = (level >= 1 && level <= 100);
        boolean goodStrength = (strength >= 0 && strength <= 100);
        boolean goodDex = (dexterity >= 0 && dexterity <= 100);
        boolean goodInt = (intelligence >= 0 && intelligence <= 100);

        return goodLevelCoherence && goodLevel && goodStrength && goodDex && goodInt;
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public abstract String presentation();

    public abstract void attaqueSimple(Character opponent);

    public abstract void attaqueSpeciale(Character opponent);

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

    public double getLife() {
        return life;
    }

    public void setLife(double newlife) {
        String action = "perd";
        if (newlife > this.life) {
            action = "gagne";
        }
        double abs = Math.abs(newlife - this.life);
        System.out.println(name + " " + action + " " + abs + " points de vie");
        this.life = newlife;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
