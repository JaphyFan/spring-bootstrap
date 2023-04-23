package com.japhy.spring.circular;

import jakarta.annotation.PostConstruct;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * test()方法没有任何约束.
 *
 * @author Japhy
 * @since 2023/4/20 00:55
 */
@Configuration
public class ConfigTest {

    public static class Demo1 {

    }

    @Bean
    public Demo1 demo1() {
        return new Demo1();
    }

    private Demo1 test() {
        return demo1();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigTest.class);
        Demo1 bean = context.getBean(Demo1.class);
        ConfigTest contextBean = context.getBean(ConfigTest.class);
        // 获得实例是同一个
        System.out.println(contextBean.test());
        System.out.println(bean);
    }

}
