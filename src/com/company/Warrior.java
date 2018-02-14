package com.company;

public class Warrior extends Character {
    public Warrior(String name, int health, int damage, int armor, int xp, int level) {
        super(name, health, damage, armor, xp, level);
    }

    public void charStatus(Character person) {
        System.out.println(person.getName() + " has " + person.getHealth() + " health remaining.");
    }
}
