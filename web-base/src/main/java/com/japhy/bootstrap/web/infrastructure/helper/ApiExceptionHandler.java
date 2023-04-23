package com.japhy.bootstrap.web.infrastructure.helper;

import com.japhy.bootstrap.web.application.wrapper.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Japhy
 * @since 2021/1/12 11:15
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError resourceNotFoundHandler(ResourceNotFoundException e) {
        return null;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError resourceNotFoundHandler(NoHandlerFoundException e) {
        return null;
    }

}
