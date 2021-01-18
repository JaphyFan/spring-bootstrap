package com.japhy.basic.relection.clazz;

import java.util.Arrays;

/**
 *
 * 1. java数组的class
 * @author Japhy
 * @since 2021/1/15 11:19
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {

        // get class
        Class<? extends String> aClass = "foo".getClass();
        System.out.println(aClass);

        byte[] bytes = new byte[1024];
        System.out.println(bytes.getClass().toString());

        int[] ints = new int[1];
        System.out.println(ints.getClass());

        // .class
        Class c = int[][][].class;
        System.out.println(c);

        // Class.forName() Class.getName()

        Class aClass1 = String.class;
        System.out.println("aClass1 get name = " + aClass1.getName());
        System.out.println("aClass1 get con name = " + aClass1.getCanonicalName());

        Class<?> aClass2 = Class.forName(aClass1.getName());
        System.out.println(aClass2);

        System.out.println(Double.TYPE);
        System.out.println(double.class);

        // 获取全部public access的类，包括继承的
        System.out.println(Arrays.toString(Character.class.getClasses()));
        // 获取全部声明类。包含私有，不包含匿名内部类
        System.out.println(Arrays.toString(Character.class.getDeclaredClasses()));

        // 获取该该匿名类的外围类
        Character.class.getEnclosingClass();
    }
}
