package com.company;

public class Mage extends Character {

    public Mage(String name, int health, int damage, int armor, int xp, int level) {
        super(name, health, damage, armor, xp ,level);
    }

    public void CharStatus(Character person) {
        System.out.println(person.getName() + " has " + person.getHealth() + " health remaining.");
    }
}
