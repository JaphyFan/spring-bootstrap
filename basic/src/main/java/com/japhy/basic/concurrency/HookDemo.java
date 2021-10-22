package com.japhy.basic.concurrency;

/**
 * @author Japhy
 * @since 2021/9/30 14:11
 */
public class HookDemo {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shut down");
        }));
    }

}
