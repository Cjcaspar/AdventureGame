package com.company;

public class Inventory {
    private int hPotion;
    private int mPotion;

    public Inventory(int hPotion) {
        this.hPotion = hPotion;
    }

    public int getHPotion() {
        return hPotion;
    }

    public void setHPotion(int hPotion) {
        this.hPotion = hPotion;
    }

    public void useHPotion(Character character) {
        if (getHPotion() > 0) {
            setHPotion(getHPotion() - 1);
            character.setHealth(character.getHealth() + 50);
            System.out.println("You drink a health potion");
        }
        else {
            System.out.println("You don't have any potions left!");
        }

    }

//    public int getmPotion() {
//        return mPotion;
//    }
//
//    public void setmPotion(int mPotion) {
//        this.mPotion = mPotion;
//    }
}
