package com.japhy.design.singleton;

/**
 * @author Japhy
 * @since 2020/11/9 16:36
 */
public class App {

    public static void main(String[] args) {
        ThreadSafeDoubleCheckLocking locking = ThreadSafeDoubleCheckLocking.getInstance();
        locking.toString();
    }

}
