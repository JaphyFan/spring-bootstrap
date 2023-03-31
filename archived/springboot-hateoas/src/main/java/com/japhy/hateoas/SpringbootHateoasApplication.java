package com.japhy.hateoas;

import com.japhy.hateoas.model.entity.User;
import com.japhy.hateoas.model.enums.Status;
import com.japhy.hateoas.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringbootHateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHateoasApplication.class, args);
    }

    /**
     * 预加载数据
     * CommandLineRunner 在spring context load 后执行
     * @param userRepository
     * @return
     */
    @Bean
    CommandLineRunner initDataBase(UserRepository userRepository) {
        return args -> {

            log.info("Preloading" + userRepository
                .save(new User(1L, "fanjh", 10, Status.CREATED)));

            log.info("Preloading" + userRepository
                .save(new User(2L, "grant", 20, Status.CREATED)));
        };
    }
}
