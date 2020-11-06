package com.japhy.basic.jdkproxy;

/**
 * @author Japhy
 * @since 2020/9/15 18:51
 */
public class App {

    public static void main(String[] args) {
        Wizard wizard1 = new Wizard();
        wizard1.setName("fanjh");

        Wizard wizard2 = new Wizard();
        wizard2.setName("zyh");

        Wizard wizard3 = new Wizard();
        wizard3.setName("great");

        IvoryTower ivoryTower = new IvoryTower();
        JdkProxy jdkProxy = new JdkProxy(ivoryTower);
        WizardTower wizardTower = (WizardTower) jdkProxy.newProxyInstance();
        wizardTower.enter(wizard1);
        wizardTower.enter(wizard2);
        wizardTower.enter(wizard3);
    }
}
