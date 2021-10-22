package com.japhy.basic.concurrency;

/**
 * @author Japhy
 * @since 2021/10/14 13:10
 */
public class UnsafeSequence {

    private volatile int anInt;

    public int getAnInt() {
        anInt = anInt + 1;
        return anInt;
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println(unsafeSequence.getAnInt()+ ":" + Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println(unsafeSequence.getAnInt() + ":" + Thread.currentThread().getName());
            }
        }).start();

    }

}
