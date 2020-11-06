package com.japhy.basic.concurrency;

/**
 * @author Japhy
 * @since 2020/11/4 16:34
 */
public class SynchroDemo2 {


    void method() {
        synchronized (this) {
            int a = 1;
        }
    }

    public static void main(String[] args) {
        SynchroDemo2 t = new SynchroDemo2();
        t.method();
        Thread thread = new Thread();
    }


}
