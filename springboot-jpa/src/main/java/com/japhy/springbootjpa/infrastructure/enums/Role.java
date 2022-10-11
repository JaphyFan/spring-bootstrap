package com.japhy.springbootjpa.infrastructure.enums;

import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2022/9/23 13:09
 */
@Getter
@AllArgsConstructor
@ToString
public enum Role {

    TEACHER(1, "教师"),

    STUDENT(2, "学生"),

    ;

    private final int id;

    private final String name;

    public static Role of(Integer id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("枚举值异常");
        }

        return Arrays.stream(Role.values()).filter(role -> Objects.equals(id, role.getId())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("未找到枚举值"));
    }

}
