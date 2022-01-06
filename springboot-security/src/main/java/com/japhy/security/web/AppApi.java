package com.japhy.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/27 14:39
 */
@RestController
@RequestMapping("/app")
public class AppApi {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
