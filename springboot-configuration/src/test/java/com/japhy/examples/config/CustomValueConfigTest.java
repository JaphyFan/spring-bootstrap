package com.japhy.examples.config;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * @author Japhy
 * @date 2020/1/16 16:15
 */
@SpringBootTest
class CustomValueConfigTest {

    @Autowired
    CustomValueConfig config;

    @Autowired
    Environment environment;

    @Test
    void testValueConfig() {
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        Assertions.assertThat(config.getName()).isEqualTo("fanjh");
        Assertions.assertThat(config.getPhone()).isEqualTo("test");
    }
}