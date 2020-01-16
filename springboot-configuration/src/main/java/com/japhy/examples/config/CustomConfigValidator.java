package com.japhy.examples.config;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Japhy
 * @date 2020/1/16 14:53
 */
public class CustomConfigValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == CustomConfig.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.blank");
    }
}
