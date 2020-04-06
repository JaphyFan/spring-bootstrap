package com.japhy.single.domain.account.repository.sample.jpa;

import com.japhy.single.domain.account.entity.User;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @author Japhy
 * @date 2019/12/31 09:12
 * 真实请求的数据库数据，Integration test
 */
@SpringBootTest
class UserAnnotationInterfaceRepositoryTest {

    @Autowired
    Environment env;

    @Autowired
    UserAnnotationInterfaceRepository userAnnotationInterfaceRepository;

    @Test
    void findByNickName() {
        List<User> uxt = this.userAnnotationInterfaceRepository.findByNickName("UXT");
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        Assertions.assertThat(uxt).hasSize(4);
    }
}