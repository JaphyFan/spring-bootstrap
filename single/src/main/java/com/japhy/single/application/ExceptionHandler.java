package com.japhy.single.application;

import com.japhy.single.api.web.AccountController;
import com.japhy.single.api.web.CustomException;
import com.japhy.single.application.wrapper.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Japhy
 * @since 2020/4/20 01:27
 */
@RestControllerAdvice(basePackageClasses = AccountController.class)
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiError> handleAllException(BindException ex, HttpHeaders headers,
        HttpStatus status, WebRequest request) {
//        return ResponseEntity.badRequest(
//            .body(ApiError.builder().description("dhjfoadf").status(122).build());
        return null;
    }
}
