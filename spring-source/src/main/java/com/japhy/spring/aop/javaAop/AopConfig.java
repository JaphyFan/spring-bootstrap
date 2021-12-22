package com.japhy.spring.aop.javaAop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Japhy
 * @since 2021/12/16 17:12
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan
public class AopConfig {

}
