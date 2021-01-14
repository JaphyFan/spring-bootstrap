package com.japhy.design.prototype;

/**
 * @author Japhy
 * @since 2020/11/16 15:10
 */
public abstract class Beast implements Prototype{

    public Beast() {
    }

    public Beast(Beast beast) {

    }

    @Override
    public abstract Beast copy();
}
