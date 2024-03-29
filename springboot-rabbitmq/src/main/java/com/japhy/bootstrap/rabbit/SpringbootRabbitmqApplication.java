package com.japhy.bootstrap.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootRabbitmqApplication implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        rabbitTemplate.convertAndSend("myQueue", "hello world");
    }

}
