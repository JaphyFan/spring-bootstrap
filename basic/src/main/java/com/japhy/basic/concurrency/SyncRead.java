package com.japhy.basic.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/10/9 11:22
 */
public class SyncRead {

    private static boolean ready;

    private static int number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }).start();
        TimeUnit.SECONDS.sleep(100);
        number = 42;
        ready = true;
    }
}
