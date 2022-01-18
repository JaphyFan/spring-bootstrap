package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @date 2019/12/30 18:22
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 查询昵称包含该字符串的用户
     * @param name
     * @return
     */
    List<User> queryAllByNickNameContains(String name);

    Optional<User> queryByNameEquals(String name);

}