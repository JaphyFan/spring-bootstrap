package com.japhy.springbootjpa;

import com.japhy.springbootjpa.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootJpaApplication implements CommandLineRunner {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveUserAndAddress(1, 2);
    }
}
