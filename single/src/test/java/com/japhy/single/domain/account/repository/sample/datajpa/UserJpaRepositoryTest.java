package com.japhy.single.domain.account.repository.sample.datajpa;

import com.japhy.single.domain.account.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author Japhy
 * @date 2020/1/12 17:08
 * {@code @DataJpaTest} is for unit testing
 * {@code @SpringbootTest} is for integration testing
 */
@DataJpaTest
class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    @Sql("data.sql")
    void queryAllByNickNameContains() {
        PageRequest request = PageRequest.of(0, 10, Sort.by(Direction.DESC, "id"));
        Page<User> fan = userJpaRepository.queryAllByNickNameContains("fan", request);
        Assertions.assertThat(fan.getContent()).hasSize(1);
    }
}