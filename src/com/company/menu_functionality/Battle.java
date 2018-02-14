package com.company.menu_functionality;
import java.util.Scanner;
import com.company.character.Character;
import com.company.character.Inventory;
import com.company.monsters.Monster;
import com.company.monsters.Necromancer;
import com.company.monsters.Orc;
import com.company.monsters.Skeleton;

public class Battle {

    public void findMonster(Character character, Inventory inv) {
        Scanner scan = new Scanner(System.in);
        Calculate calc = new Calculate();
        int findMonster = (int) (Math.random() * 100 + 1);
        if (findMonster >= 65) {
            Monster monster = createMonster(character);
            System.out.println("You encounter a " + monster.getMonsterName());
            do {
                try {
                    System.out.println("Press 1. to continue fighting, press 2 to drink a health potion, press 3 to exit game.");
                    switch (scan.nextInt()) {
                        case 1:
                            monster.setMonsterDamage();
                            battle(character, monster);
                            break;
                        case 2:
                            inv.useHPotion(character);
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println("Please enter the number 1, 2 or 3");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter the number 1 or 2");
                }
            } while (monster.getMonsterHealth() >= 0 || character.getHealth() <= 0);

            if (character.getHealth() <= 0) {
                System.out.println("You have been defeated.");
                System.exit(0);
            }
            else {
                System.out.println("Congratulations, you have defeated the " + monster.getMonsterName());
                calc.calculateXp(character, monster);
            }
        }

    }

    private void battle(Character character, Monster monster) {

        Calculate calc = new Calculate();
        System.out.println("You attack the " + monster.getMonsterName() + ".");
        int MHP1 = monster.getMonsterHealth();
        monster.setMonsterHealth(calc.calculateMHP(character, monster));
        int MHP2 = monster.getMonsterHealth();
        if (MHP2 <= 0) {
            MHP2 = 0;
        }
        System.out.println("You deal " + (MHP1 - MHP2) + " points of damage to the " + monster.getMonsterName() + ". It has " + MHP2 + " health left");

        if (monster.getMonsterHealth() >= 0) {
            System.out.println("The " + monster.getMonsterName() + " hits you back");
            int CHP1 = character.getHealth();
            character.setHealth(calc.calculateCHP(character, monster));
            int CHP2 = character.getHealth();
            System.out.println("The " + monster.getMonsterName() + " deals " + (CHP1 - CHP2) + " points of damage to you and you have " + CHP2 + " health left");
        }

    }

    private Monster createMonster(Character character) {
        int type = (int) ((Math.random()*3) + 1);

        switch(type) {
            case 1:
                return new Skeleton("Skeleton", character);
            case 2:
                return new Orc("Orc", character);
            case 3:
                return new Necromancer("Necromancer", character);
            default:
                return new Skeleton("Skeleton", character);
        }
    }
}
