package com.japhy.structure;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(StructureApplication.class, args);
        System.out.println("hello");
    }

}
