package com.japhy.examples.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Japhy
 * @date 2020/1/16 13:54
 */
@SpringBootTest
class CustomConfigTest {

    @Autowired
    CustomConfig customConfig;

    @Test
    void testConfig() {
        Assertions.assertThat(customConfig.getAge()).isLessThan(10);
        Assertions.assertThat(customConfig.getAge()).isNotNull();
        Assertions.assertThat(customConfig.getName()).isEqualTo("japhy");
        Assertions.assertThat(customConfig.getPhone()).isEqualTo("ddd");
    }

    @Test
    void testMavenProperty() {

        Assertions.assertThat(customConfig.getMavenProject()).isEqualTo("from-maven");
        Assertions.assertThat(customConfig.getAddress()).isEqualTo("from-maven-property");
        Assertions.assertThat(customConfig.getYamlProperty()).isEqualTo("yaml-property");

    }
}