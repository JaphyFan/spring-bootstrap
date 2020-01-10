package com.japhy.single.infrastructure.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Japhy
 * @date 2019/12/29 02:17
 *
 */
@AllArgsConstructor
@Getter
public enum EnvEnum {

    /**
     * 开发
     */
    DEV("dev"),

    /**
     * 测试
     */
    TEST("test"),

    /**
     * 预发布
     */
    STAGING("staging"),

    /**
     * 生产
     */
    PROD("prod"),
    ;

    private final String value;
}
