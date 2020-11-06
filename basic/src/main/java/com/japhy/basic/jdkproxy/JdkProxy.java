package com.japhy.basic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Japhy
 * @since 2020/9/15 19:01
 */
public class JdkProxy implements InvocationHandler {

    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method enter = proxy.getClass().getMethod("enter", Wizard.class);
        if (enter.equals(method)) {
            Method enter1 = target.getClass().getMethod("enter", target.getClass());
        }
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}
