package com.japhy.springsecurity.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/27 14:38
 */
@RequestMapping("/admin")
@RestController
public class AdminApi {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
