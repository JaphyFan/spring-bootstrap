package com.japhy.bootstrap.sharding.repository;

import com.japhy.bootstrap.sharding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @since 2021/11/30 16:49
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
