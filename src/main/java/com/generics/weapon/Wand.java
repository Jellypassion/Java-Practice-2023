package com.generics.weapon;

public class Wand implements MagicWeapon {
    @Override
    public int getDamage() {
        return 20;
    }

    @Override
    public String getWeaponType() {
        return "Wand";
    }
}
