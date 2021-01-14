package com.japhy.design.proxy;

/**
 * @author Japhy
 * @since 2020/11/6 15:51
 */
public class IvoryTower implements WizardTower{

    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard + "entered");
    }
}
