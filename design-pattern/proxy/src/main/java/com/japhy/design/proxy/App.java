package com.japhy.design.proxy;

/**
 * @author Japhy
 * @since 2020/11/6 15:56
 */
public class App {

    public static void main(String[] args) {
        WizardTower wizardTower = new IvoryTower();
        WizardTowerProxy proxy = new WizardTowerProxy(wizardTower);
        Wizard wizard1 = new Wizard("1");
        Wizard wizard2 = new Wizard("2");
        Wizard wizard3 = new Wizard("3");
        Wizard wizard4 = new Wizard("4");
        proxy.enter(wizard1);
        proxy.enter(wizard2);
        proxy.enter(wizard3);
        proxy.enter(wizard4);
    }
}
