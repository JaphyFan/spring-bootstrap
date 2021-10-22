package com.japhy.spring.simplest;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Japhy
 * @since 2021/7/23 18:05
 */
public class SimpleApp {

    private static Logger logger = LoggerFactory.getLogger(SimpleApp.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SimpleConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {

            logger.info("bean name : " + beanDefinitionName);
        }

        System.out.println(context.getBeanDefinitionCount());
    }
}
