package com.japhy.design.proxy;

/**
 * @author Japhy
 * @since 2020/11/6 15:54
 */
public class WizardTowerProxy implements WizardTower{

    private static final int NUM_WIZARDS_ALLOWED = 2;

    private int wizardsNum;

    private WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (wizardsNum > NUM_WIZARDS_ALLOWED) {
            System.out.println(wizard + "is rejected to enter. the tower is full");
        } else {
            wizardTower.enter(wizard);
            wizardsNum++;
        }
    }
}
