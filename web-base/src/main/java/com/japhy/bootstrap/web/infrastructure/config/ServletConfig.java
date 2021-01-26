package com.japhy.bootstrap.web.infrastructure.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/1/25 16:45
 */
@Configuration
@ServletComponentScan("com.japhy.bootstrap.web.infrastructure.filter")
public class ServletConfig {

}
