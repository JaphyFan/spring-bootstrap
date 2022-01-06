package com.japhy.servlet.web;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.japhy.servlet.web.filter.RequestResponseLoggingFilter;
import com.japhy.servlet.web.filter.TransactionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/1/25 16:45
 */
@Configuration
public class ServletConfig {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {

        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
            = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/api/v1/features/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<TransactionFilter> transactionFilter() {

        FilterRegistrationBean<TransactionFilter> registrationBean
            = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TransactionFilter());
        registrationBean.addUrlPatterns("/api/v1/features/*");
        return registrationBean;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }
}
