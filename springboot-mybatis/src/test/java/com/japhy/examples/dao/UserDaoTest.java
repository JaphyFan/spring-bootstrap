package com.japhy.examples.dao;

import com.japhy.examples.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

/**
 * @author Japhy
 * @date 2020/1/14 09:24
 */
@MybatisTest
@Import(UserDao.class)
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void selectById() {
        User user = userDao.selectById(1L);
        Assertions.assertThat(user.getId()).isEqualTo(1L);
        Assertions.assertThat(user.getName()).isEqualTo("BlKzq");
    }
}