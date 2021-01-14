package com.japhy.design.command;

/**
 * @author Japhy
 * @since 2020/11/20 14:43
 */
public class Goblin extends Target{

    public Goblin() {
        setSize(Size.BIG);
        setVisibility(Visibility.INVISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin{} " + super.toString();
    }
}
