package com.japhy.design.decorator;

/**
 * @author Japhy
 * @since 2021/2/24 14:17
 */
public class ClubbedTroll implements Troll{

    private final Troll troll;

    public ClubbedTroll(Troll troll) {
        this.troll = troll;
    }

    @Override
    public void attack() {
        troll.attack();
        System.out.println(this.toString() + "start attack with club");
    }

    @Override
    public int getAttackPower() {
        return troll.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        troll.fleeBattle();
        System.out.println(this.toString() + "flee battle with club");
    }

    @Override
    public String toString() {
        return "ClubbedTroll{" +
            "troll=" + troll +
            '}';
    }
}
