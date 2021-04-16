package com.japhy.servlet.web.api;

import com.japhy.servlet.web.dto.ValidationDto;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/4/12 16:12
 */
@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class ValidationApi {

    @PostMapping("/v1/validation")
    public ResponseEntity<String> checkValidation(@RequestBody @Valid ValidationDto validationDto) {
        log.info("validationDto is {}", validationDto);
        return ResponseEntity.ok(validationDto.toString());
    }

    @GetMapping("/v1/validation")
    public ResponseEntity<String> checkValidation2(
            @RequestParam @Range(min = 1, max = 150) Long age,
            @RequestParam @NotEmpty String name) {
        log.info("age is {}", age);
        log.info("name is {}", name);
        return ResponseEntity.ok(name + age);
    }
}
