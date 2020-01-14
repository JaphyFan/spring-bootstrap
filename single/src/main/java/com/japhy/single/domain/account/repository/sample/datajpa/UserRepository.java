package com.japhy.single.domain.account.repository.sample.datajpa;

import com.japhy.single.domain.account.entity.User;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 * @author Japhy
 * @date 2019/12/30 18:22
 */
public interface UserRepository extends Repository<User, Long> {

    /**
     * 查询昵称包含该字符串的用户
     * @param name
     * @return
     */
    List<User> queryAllByNickNameContains(String name);

}