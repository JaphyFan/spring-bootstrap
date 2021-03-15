package com.japhy.bootstrap.web.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/3/8 14:23
 */
@Configuration
@ConfigurationProperties(prefix = "custom")
@Getter
@Setter
public class CustomConfig {

    private String word;
}
