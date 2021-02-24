package com.japhy.design;

import java.util.List;

/**
 * @author Japhy
 * @since 2021/2/23 10:36
 */
public class Letter extends LetterComposite {

    private final char aChar;

    public Letter(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public void print() {
        System.out.print(aChar);
    }

    @Override
    public int count() {
        return 1;
    }
}
