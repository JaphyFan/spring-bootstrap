package com.japhy.design.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Japhy
 * @since 2020/11/20 14:44
 */
public class Wizard {

    private Deque<Runnable> redoQueue;

    private Deque<Runnable> undoQueue;

    public Wizard() {
        redoQueue = new LinkedList<>();
        undoQueue = new LinkedList<>();
    }

    public void castSpell(Runnable runnable) {
        runnable.run();
        undoQueue.offerLast(runnable);
    }

    public void redoSpell() {
        Runnable runnable = redoQueue.pollLast();
        runnable.run();
        undoQueue.offerLast(runnable);
    }

    public void undoSpell() {
        Runnable runnable = undoQueue.pollLast();
        runnable.run();
        redoQueue.offerLast(runnable);
    }

}
