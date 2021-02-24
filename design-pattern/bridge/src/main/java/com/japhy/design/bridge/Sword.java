package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:11
 */
public class Sword implements Weapon {

    private Enchantment enchantment;

    public Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void swing() {
        System.out.println(this.toString() + "swing");
        enchantment.apply();
    }

    @Override
    public void wield() {
        System.out.println(this.toString() + "wield");
        enchantment.onActive();
    }

    @Override
    public void unWield() {
        System.out.println(this.toString() + "unwield");
        enchantment.onDeactive();
    }

    @Override
    public Enchantment getEnchantment() {
        return this.enchantment;
    }

    @Override
    public String toString() {
        return "Sword{" +
            "enchantment=" + enchantment +
            '}';
    }
}
