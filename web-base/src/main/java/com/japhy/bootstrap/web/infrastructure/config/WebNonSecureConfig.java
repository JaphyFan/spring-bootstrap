package com.japhy.bootstrap.web.infrastructure.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 场景：当需要快速尝试新功能时
 * 也可以直接在配置文件中指定
 * #配置登录密码
 * spring.security.user.password=123
 * #配置登录用户名
 * spring.security.user.name=lqg
 * #配置角色名称
 * spring.security.user.roles=admin
 * @author Japhy
 * @since 2021/7/15 17:48
 */
@EnableWebSecurity
@ConditionalOnMissingBean(WebSecureConfig.class)
public class WebNonSecureConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("root").roles("USER_ADMIN");
    }
}
