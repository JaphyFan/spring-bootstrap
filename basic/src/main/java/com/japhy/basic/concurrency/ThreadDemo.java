package com.japhy.basic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Japhy
 * @since 2021/3/23 09:36
 */
public class ThreadDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Task());
        executorService.submit(new Task());
    }

    static class Task extends Thread {

        @Override
        public void run() {
            Integer i = 1;
            while (true) {
                Integer j = 2;
                i += j;
            }
        }
    }


}
