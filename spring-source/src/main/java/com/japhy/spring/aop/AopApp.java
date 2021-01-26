package com.japhy.spring.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Japhy
 * @since 2021/1/25 21:18
 */
public class AopApp {

    public static void main(String[] args) {
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("customer.xml"));
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customer.xml");
        CustomerService customerService = (CustomerService)  applicationContext.getAutowireCapableBeanFactory().getBean("customerServiceProxy");

        System.out.println(customerService.getName());
        customerService.throwException();
    }

}
