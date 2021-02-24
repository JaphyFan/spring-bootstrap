package com.japhy.design;

import java.util.List;

/**
 * @author Japhy
 * @since 2021/2/23 10:44
 */
public class Word extends LetterComposite{

    public Word(List<LetterComposite> letters) {
        letters.forEach(this::add);
    }

    @Override
    protected void printBefore() {
        System.out.print(" ");
    }
}
