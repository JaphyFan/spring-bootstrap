package com.japhy.servlet.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * @author Japhy
 * @description
 * @date 2019-07-24 01:48
 */
@WebListener
public class ListenerDemo implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context end");
    }

//    @Override
//    public void requestDestroyed(ServletRequestEvent sre) {
//        System.out.println("====================request start====================");
//    }
//
//    @Override
//    public void requestInitialized(ServletRequestEvent sre) {
//
//        System.out.println("====================request end ====================");
//    }
}
