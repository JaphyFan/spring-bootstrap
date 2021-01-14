package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:36
 */
public class App {

    public static void main(String[] args) {
        King king = new King();
        king.makeRequest(new Request("Officer"));
    }

}
