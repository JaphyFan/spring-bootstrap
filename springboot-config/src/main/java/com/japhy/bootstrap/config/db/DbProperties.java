package com.japhy.bootstrap.config.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author Japhy
 * @since 2023/3/21 01:44
 */
@Entity
@Data
public class DbProperties {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
