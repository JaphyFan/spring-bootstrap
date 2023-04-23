package com.japhy.spring.aop.aspect;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Japhy
 * @since 2021/1/26 22:47
 */
public class App {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("aspect.xml"));
        Operation operation = (Operation) beanFactory.getBean("operation");

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspect.xml");
//        Operation operation = (Operation) applicationContext.getAutowireCapableBeanFactory().getBean("operation");
        operation.k();

        operation.m();

        operation.n();
    }

}
