package com.japhy.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Japhy
 * @since 2021/2/23 10:32
 */
public abstract class LetterComposite {

    protected final List<LetterComposite> compositeList = new ArrayList<>();

    public void add(LetterComposite composite) {
        this.compositeList.add(composite);
    }

    public void print() {
        this.printBefore();
        this.compositeList.forEach(LetterComposite::print);
        this.printAfter();
    }

    public int count() {
        return this.compositeList.stream().map(LetterComposite::count)
            .reduce(Integer::sum).get();
    }

    protected void printBefore() {}

    protected void printAfter() {}

}
