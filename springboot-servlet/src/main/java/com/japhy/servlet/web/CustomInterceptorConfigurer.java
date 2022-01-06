package com.japhy.servlet.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Japhy
 * @description
 * @date 2019-07-24 10:15
 */
@Configuration
public class CustomInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorDemo()).addPathPatterns("/api/v1/gopage");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
