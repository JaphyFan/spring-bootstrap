package com.japhy.design;

import java.util.Arrays;
import java.util.List;

/**
 * @author Japhy
 * @since 2021/2/23 10:44
 */
public class Sentence extends LetterComposite{

    public Sentence(List<LetterComposite> words) {
        words.forEach(this::add);
    }

    @Override
    protected void printAfter() {
        System.out.print(".");
    }
}
