package com.japhy.springbootjpa.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Japhy
 * @since 2021/3/18 18:33
 */
@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userName;
}
