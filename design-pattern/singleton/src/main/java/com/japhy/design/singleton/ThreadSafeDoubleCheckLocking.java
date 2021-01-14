package com.japhy.design.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Japhy
 * @since 2020/11/9 16:03
 */
public class ThreadSafeDoubleCheckLocking {

    private static volatile ThreadSafeDoubleCheckLocking instance;

    private static boolean flag = true;

    private ThreadSafeDoubleCheckLocking() {
        System.out.println("begin ----flag value is " + flag);
        if (flag) {
            flag = false;
            System.out.println("flag value is " + flag);
        } else {
            throw new IllegalStateException("instance has already been initialized.");
        }
        System.out.println("end  ----flag value is " + flag);
    }

    public static ThreadSafeDoubleCheckLocking getInstance() {
        ThreadSafeDoubleCheckLocking result = instance;

        if (result == null) {
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
