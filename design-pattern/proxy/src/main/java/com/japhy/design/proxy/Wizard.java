package com.japhy.design.proxy;

/**
 * @author Japhy
 * @since 2020/11/6 15:51
 */
public class Wizard {

    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wizard{" +
            "name='" + name + '\'' +
            '}';
    }
}
