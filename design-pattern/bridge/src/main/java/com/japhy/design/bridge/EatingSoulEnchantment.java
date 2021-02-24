package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:15
 */
public class EatingSoulEnchantment implements Enchantment {

    @Override
    public void onActive() {
        System.out.println("EatingSoulEnchantment is onActive");
    }

    @Override
    public void apply() {
        System.out.println("EatingSoulEnchantment is on apply");
    }

    @Override
    public void onDeactive() {
        System.out.println("EatingSoulEnchantment is onDeactive");
    }
}
