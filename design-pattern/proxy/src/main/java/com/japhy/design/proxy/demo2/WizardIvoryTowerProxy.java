package com.japhy.design.proxy.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Japhy
 * @since 2021/2/24 17:54
 */
public class WizardIvoryTowerProxy implements IvoryTower {

    private static final Logger LOGGER = LoggerFactory.getLogger(WizardIvoryTowerProxy.class);

    private IvoryTower ivoryTower;

    private static final int MAXNUM = 2;

    private int wizards;

    public WizardIvoryTowerProxy(IvoryTower ivoryTower) {
        this.ivoryTower = ivoryTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (wizards < MAXNUM) {
            ivoryTower.enter(wizard);
            wizards++;
        } else {
            LOGGER.info(wizard + "is rejected to enter");
        }

    }
}
