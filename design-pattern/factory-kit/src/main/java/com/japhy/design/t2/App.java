package com.japhy.design.t2;


/**
 * 通过WeaponType获取Weapon的工厂.
 *
 * @author Japhy
 * @since 2020/11/5 15:42
 */
public class App {

    public static void main(String[] args) {
        WeaponFactory factory =
            WeaponFactory.factory(builder -> {
                builder.add(WeaponType.AXE, Axe::new);
                builder.add(WeaponType.Bow, Bow::new);
                builder.add(WeaponType.SPEAR, Spear::new);
                builder.add(WeaponType.SWORD, Sword::new);
            });
        Weapon weapon = factory.create(WeaponType.SWORD);
        System.out.println(weapon);
    }

}
