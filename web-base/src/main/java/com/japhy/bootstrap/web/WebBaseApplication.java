package com.japhy.bootstrap.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author japhy
 */
@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
public class WebBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBaseApplication.class, args);
        System.out.println(UriComponentsBuilder.fromHttpUrl("http://catfact.ninja/fact")
                .encode()
                .toUriString());
    }

}
