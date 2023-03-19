package com.japhy.cloud.auth.interfaces.dto;


import com.japhy.cloud.auth.entity.User;
import lombok.Builder;


@Builder
public record SignupUserDto(String email, String password, String name) {

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .name(name).build();
    }
}
