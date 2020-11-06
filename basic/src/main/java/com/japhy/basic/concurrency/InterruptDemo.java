package com.japhy.basic.concurrency;

/**
 * @author Japhy
 * @since 2020/11/4 15:40
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
            }
        });
        t.start();
        t.interrupt();
        System.out.println("1" + t.isInterrupted());
        System.out.println("2" + t.isInterrupted());
        System.out.println("end");
    }
}
