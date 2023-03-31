package com.japhy.hateoas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 当前会返回
 * "id:6 not found !"
 * 字符串
 * //FIXME: 可设置固定的返回字段，并返回json japhy 2021/1/12
 * @author Japhy
 * @since 2021/1/12 12:53
 */
@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException userNotFoundException) {
        return userNotFoundException.getMessage();
    }
}
