package com.japhy.design.decorator;

/**
 * @author Japhy
 * @since 2021/2/24 14:16
 */
public class SimpleTroll implements Troll{

    @Override
    public void attack() {
        System.out.println(this.toString() + "start attack");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        System.out.println(this.toString() + "flee battle");
    }

    @Override
    public String toString() {
        return "SimpleTroll{}";
    }
}
