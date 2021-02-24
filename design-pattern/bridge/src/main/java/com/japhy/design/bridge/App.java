package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:17
 */
public class App {

    public static void main(String[] args) {
        Weapon axe = new Axe(new EatingSoulEnchantment());
        axe.wield();
        axe.swing();
        axe.unWield();
    }

}
