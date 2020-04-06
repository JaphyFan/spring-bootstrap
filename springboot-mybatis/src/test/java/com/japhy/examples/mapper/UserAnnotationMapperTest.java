package com.japhy.examples.mapper;

import com.japhy.examples.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Japhy
 * @date 2020/1/12 21:51
 */
@MybatisTest
class UserAnnotationMapperTest {

    @Autowired
    private UserAnnotationMapper mapper;

    @Test
    void findById() {
        User user = mapper.findById(1L);
        Assertions.assertThat(user.getId()).isEqualTo(1L);
        Assertions.assertThat(user.getName()).isEqualTo("BlKzq");
        Assertions.assertThat(user.getPhone()).isEqualTo("11668682761");
    }
}