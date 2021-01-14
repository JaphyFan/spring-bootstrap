package com.japhy.design.singleton;

/**
 * @author Japhy
 * @since 2020/11/9 13:26
 */
public class IvoryTower {

    private static final IvoryTower IVORYTOWER = new IvoryTower();

    private IvoryTower() {
    }

    public static IvoryTower getInstance() {
        return IVORYTOWER;
    }
}
