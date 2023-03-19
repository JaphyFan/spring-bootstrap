package com.japhy.bootstrap.web.infrastructure.config;

import com.japhy.bootstrap.web.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Japhy
 * @since 2021/1/29 10:18
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
@Profile({"auth"})
public class WebSecureConfig {

    private final UserRepository userRepository;

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(username -> userRepository.findByUserName(username)
    //         .orElseThrow(
    //             () -> new UsernameNotFoundException(
    //                 String.format("User: %s, not found !", username))));
    //     super.configure(auth);
    // }

    @Bean
    protected SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        // 关闭cross site request forgery，开启cross origin resource share
        http.cors().and().csrf().disable();

        // 关闭session 使用jwt
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();


        http.exceptionHandling()
            .authenticationEntryPoint((request, response, authException) -> {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
            }).and();

        http.authorizeHttpRequests()
                .requestMatchers("/api/v1/features/**", "/api/public/**", "/v3/api-docs",
                        "/configuration/**", "/swagger*/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated();

        // http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Expose authentication manager bean
    // @Bean
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }


}
