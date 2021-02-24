package com.japhy.design.bridge;

/**
 * @author Japhy
 * @since 2021/2/20 15:07
 */
public interface Enchantment {

    void onActive();

    void apply();

    void onDeactive();

}
