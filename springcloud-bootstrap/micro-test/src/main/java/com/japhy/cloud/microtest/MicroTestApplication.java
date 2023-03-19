package com.japhy.cloud.microtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroTestApplication.class, args);
    }

}
