package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:14
 */
public class FlyingEnchantment implements Enchantment {

    @Override
    public void onActive() {
        System.out.println("FlyingEnchantment is on active");
    }

    @Override
    public void apply() {
        System.out.println("FlyingEnchantment is on apply");
    }

    @Override
    public void onDeactive() {
        System.out.println("FlyingEnchantment is on onDeactive");
    }
}
