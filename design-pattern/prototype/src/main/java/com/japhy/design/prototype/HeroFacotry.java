package com.japhy.design.prototype;

/**
 * @author Japhy
 * @since 2020/11/16 15:14
 */
public class HeroFacotry {

    private Beast beast;

    public HeroFacotry(Beast beast) {
        this.beast = beast;
    }

    public Object newBeast() {
        return this.beast.copy();
    }
}
