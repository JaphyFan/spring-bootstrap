package com.japhy.bootstrap.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.japhy.bootstrap.web.interfaces.dto.UserVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author japhy
 */
@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
public class WebBaseApplication {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        SpringApplication.run(WebBaseApplication.class, args);
        System.out.println(UriComponentsBuilder.fromHttpUrl("http://catfact.ninja/fact")
                .encode()
                .toUriString());

    }

}
