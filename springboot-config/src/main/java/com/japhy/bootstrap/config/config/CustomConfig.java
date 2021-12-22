package com.japhy.bootstrap.config.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;

/**
 * @author Japhy
 * @date 2020/1/16 13:52
 */
@Configuration
@ConditionalOnProperty(name = "enabled", prefix = "japhy", havingValue = "true")
@Validated
@ConfigurationProperties(prefix = "japhy", ignoreInvalidFields = true)
@Profile("dev")
@Getter
@Setter
public class CustomConfig {

    private boolean enabled;

    private String name;

    private Long age;

    private String phone;

    private String mavenProject;

    private String address;

    private String yamlProperty;

    private String demo;
}
