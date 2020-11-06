package com.japhy.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Japhy
 * @since 2020/4/14 16:35
 */
@EnableWebSecurity
public class WebSecureConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(registry -> {
            registry.antMatchers("/css/**", "/index").permitAll();
            registry.antMatchers("/user/**").hasRole("USER");
        }).formLogin(
            configurer -> configurer.loginPage("/login").failureForwardUrl("/login-error"));
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
            User.withDefaultPasswordEncoder().username("user").password("admin").roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
