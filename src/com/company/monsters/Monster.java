package com.company.monsters;

import com.company.character.Character;

public class Monster{
    private String name;
    private int health;
    private int damage;
    private int armor;
    private int level;
    private int xp;

    public Monster(String name, int health, int damage, int armor, int level, int xp) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.level = level;
        this.xp = xp;

    }

    public Monster(Character character) {
        setLevel(character);
        generateMonsterHealth();
        setMonsterDamage();
        setMonsterArmor();
        setMonsterXp();
    }

    public int getMonsterHealth() {
        return health;
    }

    public void setMonsterHealth(int health) { this.health = health;}

    public void generateMonsterHealth() {
        health =  65 + (int) (Math.random() * 50);
    }

    public int getMonsterDamage() {
        return damage;
    }

    public void setMonsterDamage() {
        damage = 3 + (int) (Math.random() * 7);
    }

    public int getMonsterArmor() {
        return armor;
    }

    public void setMonsterArmor() {
        armor = 4 + (int) (Math.random() * 6);
    }

    public String getMonsterName() {
        return name;
    }

    public void setMonsterName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(Character character) {
       int randomLevel = (int) ((Math.random()*4) - 2);
       level = character.getLevel() + randomLevel;
       if (level <= 0) {
           level = 1;
       }
    }

    public int getMonsterXp() {
        return xp;
    }

    public void setMonsterXp() {
        xp = ((getLevel() * 2) + 48);
    }
}
