package com.company.menu_functionality;

import com.company.character.Character;
import com.company.monsters.Monster;

public class Calculate {

    public int calculateMHP(Character character, Monster monster) {
        int hp = (monster.getMonsterHealth() - (character.getDamage() + (int)((Math.random() * 10) - 4) - (monster.getMonsterArmor() / 4)));
        return hp;
    }

    public int calculateCHP(Character character, Monster monster) {
        int hp = (character.getHealth() - (monster.getMonsterDamage() - character.getArmor() / 4));
        return hp;
    }

    public void calculateXp(Character character, Monster monster) {
        int xpToLevel = ((character.getLevel() * 20) + 80);
        character.setXp(character.getXp() + monster.getMonsterXp());
        if (xpToLevel <= character.getXp()) {
            character.setLevel(character.getLevel() + 1);
            character.setXp(character.getXp() - xpToLevel);
            character.setHealth((character.getLevel() * 10) + 90);
            character.setDamage(character.getDamage() + (character.getLevel() * 2));
            System.out.println("Congratulations, you leveled up to level " + character.getLevel() + "!");
        }
    }

    public void getStats(Character character) {
        System.out.println("Here are your current stats:\n" +
                "Health: " + character.getHealth() + "\n" +
                "Damage: " + character.getDamage() + "\n" +
                "Armor: " + character.getArmor() + "\n" +
                "Xp: " + character.getXp() + "/" + ((character.getLevel() * 20) + 80) + "\n" +
                "Level: " + character.getLevel() + "\n");
    }
}
