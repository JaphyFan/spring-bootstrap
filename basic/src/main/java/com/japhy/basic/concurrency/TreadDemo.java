package com.japhy.basic.concurrency;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Japhy
 * @since 2020/11/3 10:21
 */
public class TreadDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            Runnable r = () -> {
                int a = 1;
                int b = 2;
                System.out.println(a + b);
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(r, "hello");
            thread.start();
        }
    }
}
