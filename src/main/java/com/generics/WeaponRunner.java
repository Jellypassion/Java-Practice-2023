package com.generics;

import com.generics.weapon.Bow;
import com.generics.weapon.Sword;
import com.generics.weapon.Weapon;
import com.heroes.Archer;
import com.heroes.Hero;
import com.heroes.Warrior;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer1 = new Archer<>("Леголас", 15);
        archer1.setWeapon(new Bow());
        printWeaponDamage(archer1);

        Warrior<Sword> warrior1 = new Warrior<>("Боромир", 10);
        warrior1.setWeapon(new Sword());
        printWeaponDamage(warrior1);
    }

    public static void printWeaponDamage(Hero<? extends Weapon> hero) {
        System.out.print("Weapon:" + hero.getWeapon().getWeaponType() + "; ");
        System.out.println("Damage:" + hero.getWeapon().getDamage());
    }
}
