package com.japhy.basic;

/**
 * @author Japhy
 * @since 2022/6/1 16:31
 */
public class Demo {

    private String name;

    public Demo(String name) {
        this.name = name;
    }

    public boolean differ(Demo d2) {
        if (d2.name.equalsIgnoreCase(this.name)) {
            return true;
        }
        return false;
    }

    public void callInner() {
        Demo.InnerDemo demo =this.new InnerDemo();
        InnerDemo innerDemo = this.new InnerDemo();
        innerDemo.hello();
    }

    static class A {

    }

    static class B extends A {

    }

    class InnerDemo {

        private String name2;

        public void hello() {
            name2 = name;
        }
    }



    public static void main(String[] args) {
        Demo f = new Demo("f");
        System.out.println(f);
        A a = new B();
        B b1 = (B) new A();

    }
}
