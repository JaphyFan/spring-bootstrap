package com.japhy.basic.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/10/27 15:45
 */
public class DeadLock {

    static class Item {

    }

    public static void main(String[] args) {
        final Item a = new Item();
        final Item b = new Item();

        new Thread(() -> {
            synchronized (a) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " runed");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " runed");
                }
            }
        }).start();

    }

}
