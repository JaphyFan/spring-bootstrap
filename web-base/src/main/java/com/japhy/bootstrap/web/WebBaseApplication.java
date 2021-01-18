package com.japhy.bootstrap.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author japhy
 */
@SpringBootApplication(exclude = {RabbitAutoConfiguration.class, SecurityAutoConfiguration.class,
    ManagementWebSecurityAutoConfiguration.class})
public class WebBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBaseApplication.class, args);
    }

}
