package com.japhy.bootstrap.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @date 2020/1/16 14:37
 * {@code @Value} 无法使用 prefix, 全名必须
 */
@Component
@ConditionalOnProperty(prefix = "japhy", name = "enabled", havingValue = "true")
public class CustomValueConfig {

    @Value("${japhy.name:fanjh}")
    private String name;

    @Value("${japhy.age:2}")
    private Long age;

    @Value("${japhy.phone:12333}")
    private String phone;

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
