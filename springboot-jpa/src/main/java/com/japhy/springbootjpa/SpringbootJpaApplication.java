package com.japhy.springbootjpa;

import com.japhy.springbootjpa.domain.user.UserService;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootJpaApplication implements CommandLineRunner {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userService.saveUserAndAddress(1, 2);
    }

    /**
     * 和springboot集成的h2数据库，用于在运行时挂住数据库，方便查看数据.
     * 和test启动的库同端口，平时注视掉
     * @return
     * @throws SQLException
     */
    // @Bean(initMethod = "start", destroyMethod = "stop")
    // public Server inMemoryH2DatabaseServer() throws SQLException {
    //     return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
    // }
}
