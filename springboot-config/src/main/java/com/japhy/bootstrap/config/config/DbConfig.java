package com.japhy.bootstrap.config.config;

import com.japhy.bootstrap.config.db.DbConfigRepository;
import com.japhy.bootstrap.config.db.DbProperties;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author Japhy
 * @since 2023/3/21 01:21
 */
@Configuration
@Lazy
@Getter
public class DbConfig {

    private DbProperties dbProperties = null;

    @Autowired
    public DbConfigRepository dbConfigRepository;

    @PostConstruct
    public void init() {
        dbProperties = dbConfigRepository.findById(1L).orElse(new DbProperties());
    }


}
