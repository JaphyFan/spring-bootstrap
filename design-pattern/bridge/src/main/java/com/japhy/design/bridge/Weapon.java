package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:09
 */
public interface Weapon {

    void swing();

    void wield();

    void unWield();

    Enchantment getEnchantment();

}
