package com.japhy.basic.lamda;

import java.util.function.Consumer;

/**
 * @author Japhy
 * @since 2021/1/15 10:38
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello world");
    }
}
