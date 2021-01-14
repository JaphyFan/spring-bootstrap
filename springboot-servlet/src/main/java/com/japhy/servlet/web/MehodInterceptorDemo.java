package com.japhy.servlet.web;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Japhy
 * @description
 * @date 2019-07-24 11:01
 */
public class MehodInterceptorDemo implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getMethod().getName() + "****************");
        return methodInvocation.proceed();
    }
}
