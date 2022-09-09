package com.japhy.basic.lamda;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Japhy
 * @since 2021/1/15 10:38
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        List<Artist> collect = Stream.of(new Artist("f", null), new Artist("j", null))
                .collect(Collectors.toList());

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello world");
    }
}
