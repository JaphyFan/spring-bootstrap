package com.japhy.bootstrap.web.domain.user.repository;

import com.japhy.bootstrap.web.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @since 2021/1/8 16:35
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
