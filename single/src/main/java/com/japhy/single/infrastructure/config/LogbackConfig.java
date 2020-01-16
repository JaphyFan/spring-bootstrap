package com.japhy.single.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Japhy
 * @date 2020/1/16 10:07
 */
@Configuration
@ImportResource("classpath:logback-spring.xml")
public class LogbackConfig {

}
