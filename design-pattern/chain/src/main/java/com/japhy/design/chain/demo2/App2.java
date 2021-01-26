package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 11:26
 */
public class App2 {

    public static void main(String[] args) {
        King king = new King();
        king.makeRequest(new Request(RequestType.OFFICER));
    }

}
