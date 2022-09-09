package com.japhy.basic;

/**
 * @author Japhy
 * @since 2022/7/5 16:46
 */
public class CharDemo {

    public static void main(String[] args) {
        // length计算的是代码代码单元长度，部分字符由两个代码单元组成的情况下会错误
        String s = "𝜽";
        System.out.println(s.length());

    }

}
