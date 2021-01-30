package com.japhy.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect indicates an aspect pointcut indicates a expresion to the joinpoint joinpoint indicates
 * the actual method advice indicates actions to execute in the joinpoint proxy indicates the way to
 * make aop
 *
 * @author Japhy
 * @since 2021/1/26 22:48
 */

@Aspect
@Slf4j
public class Track {

    @Pointcut("execution(* com.japhy.spring.aop.aspect.Operation.k(..))")
    public void k() {
    }

    @Before("execution(* com.japhy.spring.aop.aspect.Operation.k(..))")
    public void beforeK() {
        log.info("something happened before k.........");
    }

    @After("k()")
    public void afterK() {
        log.info("hhhh k is done");
    }

    @AfterReturning("k()")
    public void afterKReturn() {
        log.info("after k is returned");
    }

}
