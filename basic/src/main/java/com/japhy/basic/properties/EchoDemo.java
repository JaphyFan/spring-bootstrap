package com.japhy.basic.properties;

import com.japhy.basic.annotation.MyAnnotation;

/**
 * @author Japhy
 * @since 2020/10/30 14:35
 */
public class EchoDemo {


    public static void main(String[] args) {
        test();
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    @MyAnnotation
    private static void test() {
        System.out.println("hello");
    }
}
