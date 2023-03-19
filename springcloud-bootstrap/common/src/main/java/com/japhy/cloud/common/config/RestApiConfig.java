package com.japhy.cloud.common.config;

import com.japhy.cloud.common.exceptions.GlobalExceptionHandler;
import com.japhy.cloud.common.filter.JwtFeignFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2023/3/15 00:31
 */
@ConditionalOnBean(RestApiMarkerConfig.Marker.class)
@Configuration
public class RestApiConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public JwtFeignFilter jwtFilter() {
        return new JwtFeignFilter();
    }

}
