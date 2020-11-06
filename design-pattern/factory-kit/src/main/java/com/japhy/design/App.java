package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/6/10 18:51
 */
public class App {

    public static void main(String[] args) {
        WeaponFactory factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.BOW, Bow::new);
            builder.add(WeaponType.SWORD, Sword::new);
        });
        Weapon weapon = factory.create(WeaponType.AXE);
    }

}
