package com.japhy.cloud.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2023/3/14 22:51
 */
@Configuration(proxyBeanMethods = false)
public class RestApiMarkerConfig {

    @Bean
    public Marker restApiMarkerBean() {
        return new Marker();
    }

    class Marker {

    }

}
