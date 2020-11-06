package com.japhy.jmeter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2020/9/4 10:33
 */
@RestController
@RequestMapping("/jmeter")
@Slf4j
public class JemeterApi {

    @GetMapping("api/v1/demo")
    public ResponseEntity<String> demo(@RequestParam("userId") Long userId,
        @RequestParam("userName") String userName) {
        log.info("userId:" + userId + ", userName:" + userName);
        return ResponseEntity.ok("userId:" + userId + ", userName:" + userName);
    }
}
