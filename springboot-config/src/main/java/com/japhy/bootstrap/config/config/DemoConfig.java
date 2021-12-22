package com.japhy.bootstrap.config.config;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Japhy
 * @since 2021/8/13 17:11
 */
@Configuration
@PropertySource("classpath:config.properties")
@Setter
@Getter
public class DemoConfig {

    @Value("#{${Measurement}}")
    private Map<String, String> measurement;
}
