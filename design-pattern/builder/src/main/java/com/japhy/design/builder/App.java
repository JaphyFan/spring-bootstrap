package com.japhy.design.builder;

import com.japhy.design.builder.Person.Builder;

/**
 * @author Japhy
 * @since 2020/11/16 16:35
 */
public class App {

    public static void main(String[] args) {
        Builder builder = Person.builder();
        Person build = builder.address("hangzhou").age(1).name("japhy").build();
        System.out.println(build);
    }

}
