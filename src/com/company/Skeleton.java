package com.company;

public class Skeleton extends Monster {



    public Skeleton(String name, int health, int damage, int armor, int level, int xp) {
        super(name, health, damage, armor, level, xp);
    }

    public Skeleton(String name, Character character) {
        super(character);
        setMonsterName(name);
        setLevel(character);
        generateMonsterHealth();
        setMonsterDamage();
        setMonsterArmor();
    }
}