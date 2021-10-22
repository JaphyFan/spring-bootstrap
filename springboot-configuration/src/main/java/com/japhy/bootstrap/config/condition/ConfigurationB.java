package com.japhy.bootstrap.config.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/8/20 17:52
 */
@Configuration
public class ConfigurationB {

    @Bean
    public MyBean myBean() {
        return new MyBean("japhy");
    }
}
