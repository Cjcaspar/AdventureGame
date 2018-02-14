package com.company.character;

import com.company.character.Character;

public class Rogue extends Character {
    public Rogue(String name, int health, int damage, int armor, int xp, int level) {
        super(name, health, damage, armor, xp, level);
    }

    public void CharStatus(Character person) {
        System.out.println(person.getName() + " has " + person.getHealth() + " health remaining.");
    }
}
