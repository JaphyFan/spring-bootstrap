package com.japhy.single.domain.account.repository.sample.datajpa;

import com.japhy.single.domain.account.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @date 2019/12/30 17:45
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    /**
     * 用户昵称内包含字段，并分页
     * @param nickName
     * @param pageable
     * @return
     */
    Page<User> queryAllByNickNameContains(String nickName, Pageable pageable);
}
