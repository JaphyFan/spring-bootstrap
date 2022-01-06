package com.japhy.security.config;

import com.japhy.security.filter.VerificationCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Japhy
 * @since 2020/4/14 16:35
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Lazy
    @Qualifier("userRepositoryUserDetailsService")
    private UserDetailsService userDetailsService;

//    public WebSecurityConfig(
//        @Lazy @NonNull @Qualifier("userRepositoryUserDetailsService")
//            UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(registry -> {
            registry.antMatchers("/admin/**").hasRole("ADMIN");
            registry.antMatchers("/app/**").permitAll();
            registry.antMatchers("/api/v1/users/**").hasRole("USER");

            registry.antMatchers("/user/**").hasRole("USER");
            registry.antMatchers("/css/**", "/index").permitAll();
            registry.antMatchers("/captcha/captcha.jpg").permitAll();
        }).formLogin(
            configurer -> configurer.loginPage("/login").loginProcessingUrl("/auth/form")
                .failureForwardUrl("/login-error")
                .defaultSuccessUrl("/", true))
            .logout().logoutSuccessUrl("/")
            .logoutSuccessHandler((request, response, authentication) -> {
                // to something when log out
            }).invalidateHttpSession(true).clearAuthentication(true)
            .deleteCookies("cookie1", "cookie2")

            .and()
            .csrf().disable()
            .sessionManagement().maximumSessions(1);

        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/images/**", "/styles/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
//
//    // 内存数据库实现账号密码
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password(encoder().encode("123")).roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(encoder().encode("123")).roles("ADMIN").build());
//
//        return manager;
//    }
//
    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }
}
