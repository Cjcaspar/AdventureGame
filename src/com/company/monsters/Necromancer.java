package com.company.monsters;

import com.company.character.Character;

public class Necromancer extends Monster {

    public Necromancer(String name, int health, int damage, int armor, int level, int xp) {
        super(name, health, damage, armor, level, xp);
    }

    public Necromancer(String name, Character character) {
        super(character);
        setMonsterName(name);
        setLevel(character);
        generateMonsterHealth();
        setMonsterDamage();
        setMonsterArmor();
    }
}
