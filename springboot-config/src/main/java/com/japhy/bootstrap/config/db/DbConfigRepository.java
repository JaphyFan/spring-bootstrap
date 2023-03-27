package com.japhy.bootstrap.config.db;

import com.japhy.bootstrap.config.config.DbConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @since 2023/3/21 01:25
 */
public interface DbConfigRepository extends JpaRepository<DbProperties, Long> {


}
