package com.company;
import com.company.character.*;
import com.company.character.Character;
import com.company.menu_functionality.Battle;
import com.company.menu_functionality.Calculate;

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

        Battle battle = new Battle();
        Calculate calc = new Calculate();

        Inventory inv = new Inventory(5);

        boolean i = true;
        while (i) {
            System.out.println("1. Move right\n2. Move left\n3. Move up\n4. Move down \n5. Check character status\n6. Exit");
        switch (scan.nextInt()) {
            case 1:
                System.out.println("You move 1 space right");
                battle.findMonster(character, inv);
                break;
            case 2:
                System.out.println("You move 1 space left");
                battle.findMonster(character, inv);
                break;
            case 3:
                System.out.println("You move 1 space up");
                battle.findMonster(character, inv);
                break;
            case 4:
                System.out.println("You move 1 space down");
                battle.findMonster(character, inv);
                break;
            case 5:
                calc.getStats(character);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Please enter a number 1 through 4");
                break;
        }
        }


    }





}

