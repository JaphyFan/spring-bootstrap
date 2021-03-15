package com.japhy.design.proxy.demo2;

/**
 * @author Japhy
 * @since 2021/2/24 17:52
 */
public class Wizard {

    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
