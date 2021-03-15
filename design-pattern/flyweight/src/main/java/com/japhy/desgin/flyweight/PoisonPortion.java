package com.japhy.desgin.flyweight;

/**
 * @author Japhy
 * @since 2021/2/24 19:37
 */
public class PoisonPortion implements Portion {

    @Override
    public void drink() {
        System.out.println("drink PoisonPortion");
    }
}
