package com.japhy.springsecurity;

import javax.naming.AuthenticationException;

/**
 * @author Japhy
 * @since 2021/1/27 16:50
 */
public class VerificationException extends AuthenticationException {

    public VerificationException() {
        super("验证码校验失败");
    }
}
