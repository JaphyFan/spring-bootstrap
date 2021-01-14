package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/11/12 11:37
 */
public class App {

    public static void main(String[] args) {
        KingdomFactory factory = Kingdom.factory(KingdomType.ELF);
        System.out.println(factory.createArmy());
        System.out.println(factory.createCastle());
    }

}
