package com.japhy.servlet;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Japhy
 * @description
 * @date 2019-07-25 18:52
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = IllegalAccessException.class)
    Object handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("url {}, msg {}", request.getRequestURI(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("url", request.getRequestURI());
        map.put("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class,
            ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Object handleApiArgumentValidation(Exception e, HttpServletRequest request,
            HttpServletResponse response) {

        LOGGER.error("url {}, msg {}", request.getRequestURI(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("url", request.getRequestURI());
        map.put("msg", e.getMessage());
        return map;
    }


}
