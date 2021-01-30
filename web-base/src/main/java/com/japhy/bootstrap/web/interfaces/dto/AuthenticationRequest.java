package com.japhy.bootstrap.web.interfaces.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2021/1/30 14:51
 */
@Getter
@ToString
public class AuthenticationRequest {

    private String userName;

    private String password;
}
