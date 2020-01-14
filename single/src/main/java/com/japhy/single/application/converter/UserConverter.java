package com.japhy.single.application.converter;

import com.japhy.single.api.dto.UserDTO;
import com.japhy.single.domain.account.entity.User;
import com.japhy.single.infrastructure.helper.Converter;

/**
 * @author Japhy
 * @date 2020/1/2 02:17
 */
public class UserConverter extends Converter<UserDTO, User> {

    public UserConverter() {
        super(dto -> User.builder().name(dto.getName()).phone(dto.getPhone()).build(),
                user -> UserDTO.builder().avatar(user.getAvatar()).name(user.getName())
                        .phone(user.getPhone()).build());
    }
}
