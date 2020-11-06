package com.japhy.basic.concurrency;

/**
 * @author Japhy
 * @since 2020/11/3 10:21
 */
public class TreadDemo {

    public static void main(String[] args) {
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
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
