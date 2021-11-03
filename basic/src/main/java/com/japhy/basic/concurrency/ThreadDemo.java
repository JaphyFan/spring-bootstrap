package com.japhy.basic.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/3/23 09:36
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Task());
        executorService.submit(new Task());
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        if (executorService.isTerminated()) {
            executorService.shutdownNow();
        }
    }

    static class Task extends Thread {

        @Override
        public void run() {
            int i = 1;
            while (true) {
                int j = 2;
                i += j;
            }
        }
    }


}
