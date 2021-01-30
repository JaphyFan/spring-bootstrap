package com.japhy.bootstrap.web.interfaces.dto;

import java.util.Set;
import lombok.Data;

/**
 * @author Japhy
 * @since 2021/1/30 15:21
 */
@Data
public class CreateUserRequest {


    private String userName;
    private String fullName;

    private String password;

    private String rePassword;

    private Set<String> authorities;

}
