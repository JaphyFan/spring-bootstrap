package com.japhy.basic;

/**
 * @author Japhy
 * @since 2022/9/16 15:56
 */
public class InterfaceDefaultDemo {

    interface A {

        void h(int i);
    }

    interface B extends A {

        @Override
        default void h(int i) {
            System.out.println(i);
        }
    }

    static class C implements B {

        public static void main(String[] args) {
            B b = new C();
            b.h(111);
        }
    }

}
