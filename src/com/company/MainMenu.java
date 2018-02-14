package com.company;
import java.util.Scanner;

public class MainMenu {
    Scanner scan = new Scanner(System.in);

    public void createCharacter() {

        System.out.println("Please create your character\n1. Mage\n2. Rogue\n3. Warrior\n4. Exit game");
            try {
                switch (scan.nextInt()) {
                    case 1:
                        Mage mage = new Mage(" ", 100, 15, 8, 0 ,1);
                        mage.setName();
                        game(mage);
                        break;
                    case 2:
                        Rogue rogue = new Rogue(" ", 100, 12, 12, 0 , 1);
                        rogue.setName();
                        game(rogue);
                        break;
                    case 3:
                        Warrior warrior = new Warrior(" ", 100, 10, 16, 0, 1);
                        warrior.setName();
                        game(warrior);
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 4");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 4");
            }
    }

    private void game(Character character) {

        Inventory inv = new Inventory(5);

        boolean i = true;
        while (i) {
            System.out.println("1. Move right\n2. Move left\n3. Move up\n4. Move down \n5. Check character status\n6. Exit");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("You move 1 space right");
                findMonster(character, inv);
                break;
            case 2:
                System.out.println("You move 1 space left");
                findMonster(character, inv);
                break;
            case 3:
                System.out.println("You move 1 space up");
                findMonster(character, inv);
                break;
            case 4:
                System.out.println("You move 1 space down");
                findMonster(character, inv);
                break;
            case 5:
                getStats(character);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Please enter a number 1 through 4");
                break;
        }
        }


    }

    private void findMonster(Character character, Inventory inv) {
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
                calculateXp(character, monster);
            }
        }

    }

    private int calculateMHP(Character character, Monster monster) {
        int hp = (monster.getMonsterHealth() - (character.getDamage() + (int)((Math.random() * 10) - 4) - (monster.getMonsterArmor() / 4)));
        return hp;
    }

    private int calculateCHP(Character character, Monster monster) {
        int hp = (character.getHealth() - (monster.getMonsterDamage() - character.getArmor() / 4));
        return hp;
    }

    private void battle(Character character, Monster monster) {


        System.out.println("You attack the " + monster.getMonsterName() + ".");
        int MHP1 = monster.getMonsterHealth();
        monster.setMonsterHealth(calculateMHP(character, monster));
        int MHP2 = monster.getMonsterHealth();
        if (MHP2 <= 0) {
            MHP2 = 0;
        }
        System.out.println("You deal " + (MHP1 - MHP2) + " points of damage to the " + monster.getMonsterName() + ". It has " + MHP2 + " health left");

        if (monster.getMonsterHealth() >= 0) {
            System.out.println("The " + monster.getMonsterName() + " hits you back");
            int CHP1 = character.getHealth();
            character.setHealth(calculateCHP(character, monster));
            int CHP2 = character.getHealth();
            System.out.println("The " + monster.getMonsterName() + " deals " + (CHP1 - CHP2) + " points of damage to you and you have " + CHP2 + " health left");
        }

    }

    private void calculateXp(Character character, Monster monster) {
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

    private void getStats(Character character) {
        System.out.println("Here are your current stats:\n" +
                "Health: " + character.getHealth() + "\n" +
                "Damage: " + character.getDamage() + "\n" +
                "Armor: " + character.getArmor() + "\n" +
                "Xp: " + character.getXp() + "/" + ((character.getLevel() * 20) + 80) + "\n" +
                "Level: " + character.getLevel() + "\n");
    }

    private static Monster createMonster(Character character) {
        int type = (int) ((Math.random()*3) + 1);

        switch(type) {
            case 1:
                return new Skeleton("Skeleton", character);
            case 2:
                return new Orc ("Orc", character);
            case 3:
                return new Necromancer ("Necromancer", character);
            default:
                return new Skeleton("Skeleton", character);
        }
    }

}

