package com.enums.weapon;

public class Sword implements MeleeWeapon {

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public String getWeaponType() {
        return "Sword";
    }
}
