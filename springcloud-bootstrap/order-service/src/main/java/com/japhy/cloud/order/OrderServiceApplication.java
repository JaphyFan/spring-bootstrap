package com.japhy.cloud.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableFeignClients
@EnableRetry
public class OrderServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(OrderServiceApplication.class, args);
    }
    @Component
    @Slf4j
    static class CommandLineAppStartupRunner implements CommandLineRunner {

        @Value("${project.basedir}")
        private String projectBase;

        @Value("${app.test}")
        private String appTest;

        @Override
        public void run(String...args) throws Exception {
            log.info("projectBase directory is : " + projectBase);
            log.info("decrypted app.test is : " + appTest);
        }
    }

}
