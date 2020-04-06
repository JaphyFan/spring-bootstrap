package com.japhy.examples.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.japhy.examples.model.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

/**
 * @author Japhy
 * @date 2020/1/14 09:25
 */
@MybatisTest
@Import(PageInterceptor.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        List<User> all1 = userMapper.findAll();
        Assertions.assertThat(all1).hasSize(3);
        userMapper.insert(user);
        List<User> all = userMapper.findAll();
        Assertions.assertThat(all).hasSize(4);
        Assertions.assertThat(all.get(3).getId()).isEqualTo(4);
    }

    @Test
    void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1L);
        Assertions.assertThat(user.getId()).isEqualTo(1L);
        Assertions.assertThat(user.getName()).isEqualTo("BlKzq");
    }

    @Test
    void updateByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1L);
        Assertions.assertThat(user.getName()).isEqualTo("BlKzq");
        user.setName("japhy");
        userMapper.updateByPrimaryKey(user);
        User user1 = userMapper.selectByPrimaryKey(1L);
        Assertions.assertThat(user1.getName()).isEqualTo("japhy");
    }

    @Test
    void findAll() {
        PageInfo<User> page1 = PageHelper.startPage(1, 2)
                .doSelectPageInfo(() -> userMapper.findAll());
        long total = page1.getTotal();
        Assertions.assertThat(total).isEqualTo(3);
        Assertions.assertThat(page1.getList()).hasSize(2);

        PageHelper.startPage(0, 3);
        List<User> all2 = userMapper.findAllPaged();
        PageInfo<User> page2 = PageInfo.of(all2);
        Assertions.assertThat(page2.getList()).hasSize(3);

        PageHelper.startPage(0, 4);

        List<User> all3 = userMapper.findAllPaged();
        PageInfo<User> page3 = PageInfo.of(all3);
        Assertions.assertThat(page3.getList()).hasSize(3);

        PageHelper.startPage(2, 4);
        List<User> all4 = userMapper.findAllPaged();
        PageInfo<User> page4 = PageInfo.of(all4);
        Assertions.assertThat(page4.getList()).hasSize(0);

    }
}