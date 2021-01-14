package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:33
 */
public class King {

    private RequestHandler chain;

    public King() {
        build();
    }

    public void build() {
        chain = new Commander(new Officer(new Soldier(null)));
    }

    public void makeRequest(Request request) {
        chain.handleRequest(request);
    }
}
