package com.japhy.basic.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/9/30 15:00
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(100);
    }
}
