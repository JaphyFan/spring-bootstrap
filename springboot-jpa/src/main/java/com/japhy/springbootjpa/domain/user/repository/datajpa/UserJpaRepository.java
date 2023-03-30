package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @date 2019/12/30 17:45
 */
public interface UserJpaRepository extends JpaRepository<User, Long> {

    /**
     * 用户昵称内包含字段，并分页
     * @param nickName
     * @param pageable
     * @return
     */
    Page<User> queryAllByNickNameContains(String nickName, Pageable pageable);

    Optional<User> findFirstByName(String name);
}
