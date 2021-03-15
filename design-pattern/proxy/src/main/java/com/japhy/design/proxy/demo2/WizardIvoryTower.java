package com.japhy.design.proxy.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Japhy
 * @since 2021/2/24 17:53
 */
public class WizardIvoryTower implements IvoryTower {

    private static final Logger LOGGER = LoggerFactory.getLogger(WizardIvoryTower.class);

    @Override
    public void enter(Wizard wizard) {
        LOGGER.info(wizard.toString() + "entered");
    }
}
