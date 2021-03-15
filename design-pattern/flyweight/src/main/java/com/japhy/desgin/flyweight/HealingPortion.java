package com.japhy.desgin.flyweight;

/**
 * @author Japhy
 * @since 2021/2/24 19:36
 */
public class HealingPortion implements Portion {

    @Override
    public void drink() {
        System.out.println("drink HealingPortion");
    }
}
