package com.japhy.spring.simplest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Japhy
 * @since 2021/7/23 18:05
 */
@Slf4j
public class SimpleApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SimpleConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            log.info("bean name : " + beanDefinitionName);
        }
        System.out.println(context.getBeanDefinitionCount());
    }
}
