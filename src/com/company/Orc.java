package com.company;

public class Orc extends Monster {

    public Orc(String name, int health, int damage, int armor, int level, int xp) {
        super(name, health, damage, armor, level, xp);
    }

    public Orc(String name, Character character) {
        super(character);
        setMonsterName(name);
        setLevel(character);
        generateMonsterHealth();
        setMonsterDamage();
        setMonsterArmor();
    }
}
