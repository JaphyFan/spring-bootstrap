package com.japhy.bootstrap.config;

import com.japhy.bootstrap.config.config.CustomConfigValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

@SpringBootApplication
public class SpringbootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConfigApplication.class, args);
    }

    /**
     *
     * TODO: why must call this name? japhy 2020/1/16
     */
    @Bean
    public static Validator configurationPropertiesValidator() {
        return new CustomConfigValidator();
    }


}
