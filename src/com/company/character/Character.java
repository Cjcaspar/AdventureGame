package com.company.character;
import java.util.Scanner;

public class Character {
    Scanner scan = new Scanner(System.in);
    private String name;
    private int health;
    private int damage;
    private int armor;
    private int xp;
    private int level;

    public Character(String name, int health, int damage, int armor, int xp, int level) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.xp = xp;
        this.level = level;
    }



    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("What is your character's name?");
        name = scan.nextLine();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getXp () {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() { return level;}

    public void charStatus(Character person) {
        System.out.println(person.getName() + " has " + person.getHealth() + " health remaining.");
    }



}
