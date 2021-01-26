package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 10:56
 */
public class King {

    public void makeRequest(Request request) {
        RequestHandler handler = new Officer(new Solider(null));
        handler.handleRequest(request);
    }
}
