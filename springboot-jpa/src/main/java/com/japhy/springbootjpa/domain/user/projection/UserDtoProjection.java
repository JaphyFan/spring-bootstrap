package com.japhy.springbootjpa.domain.user.projection;

import lombok.Getter;

/**
 * @author Japhy
 * @since 2021/4/12 11:29
 */
public class UserDtoProjection {

    private final String name;

    public UserDtoProjection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
