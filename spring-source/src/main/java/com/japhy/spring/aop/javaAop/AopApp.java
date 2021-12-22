package com.japhy.spring.aop.javaAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Japhy
 * @since 2021/12/16 17:26
 */
public class AopApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);
        Operation bean = applicationContext.getBean(Operation.class);
        bean.k();
    }

}
