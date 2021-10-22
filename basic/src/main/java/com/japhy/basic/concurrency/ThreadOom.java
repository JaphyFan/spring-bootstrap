package com.japhy.basic.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/10/11 09:30
 */
public class ThreadOom {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("the thread is ");
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            System.out.println(i);
        }
    }

}
