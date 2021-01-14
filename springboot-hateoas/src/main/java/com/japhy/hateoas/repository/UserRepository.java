package com.japhy.hateoas.repository;

import com.japhy.hateoas.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @since 2021/1/12 11:29
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
