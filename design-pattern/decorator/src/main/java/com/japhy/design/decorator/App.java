package com.japhy.design.decorator;

/**
 * @author Japhy
 * @since 2021/2/24 14:19
 */
public class App {

    public static void main(String[] args) {
        Troll clubbedTroll = new ClubbedTroll(new SimpleTroll());
        clubbedTroll.attack();
        System.out.println(clubbedTroll.getAttackPower());
        clubbedTroll.fleeBattle();
    }

}
