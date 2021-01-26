package com.japhy.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Japhy
 * @since 2021/1/25 01:27
 */
@Slf4j
public class App {

    public static void main(String[] args) {
//        BeanFactory beanFactory =
//            new XmlBeanFactory(new ClassPathResource("user-factory.xml"));
//        User user = (User) beanFactory.getBean("user");

//        log.info(user.toString());
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("user-factory.xml");
        User user1 = (User) applicationContext.getAutowireCapableBeanFactory().getBean("user");

        log.info(user1.toString());

        // 测试setter注入
        User user2 = (User) applicationContext.getAutowireCapableBeanFactory().getBean("user2");
        log.info(user2.toString());

        User user3 = (User) applicationContext.getAutowireCapableBeanFactory().getBean("user3");
        log.info(user3.toString());

        ClassPathXmlApplicationContext context =
            (ClassPathXmlApplicationContext) applicationContext;
        context.close();


    }

}
