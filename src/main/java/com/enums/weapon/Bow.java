package com.enums.weapon;

public class Bow implements RangeWeapon {
    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public String getWeaponType() {
        return "Bow";
    }
}
