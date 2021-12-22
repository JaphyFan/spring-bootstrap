package com.japhy.spring.aop.javaAop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/12/16 17:13
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Before("execution(* com.japhy.spring.aop.javaAop.Operation.k(..))")
    public void beforeMethod() {
        log.info("hello before the method -====");
    }
}
