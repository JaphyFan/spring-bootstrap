package com.japhy.basic.relection.clazz;

import static java.lang.System.out;


import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @author Japhy
 * @since 2021/1/15 12:20
 */
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> aClass = Class.forName("[Ljava.lang.String;");
        out.println("clazz name:" +  aClass.getCanonicalName());
        out.println("clazz modifiers:" + Modifier.toString(aClass.getModifiers()));
        TypeVariable<? extends Class<?>>[] typeParameters = aClass.getTypeParameters();
        out.println("type variables:" + Arrays.toString(typeParameters));
        out.println("getGenericInterfaces: " + Arrays.toString(aClass.getGenericInterfaces()));
        out.println("getSuperclass: " + aClass.getSuperclass());
        out.println("getAnnotations: " + Arrays.toString(aClass.getAnnotations()));

    }
}
