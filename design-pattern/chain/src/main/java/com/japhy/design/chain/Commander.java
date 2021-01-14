package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:26
 */
public class Commander extends RequestHandler{

    public Commander(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals("Commander")) {
            request.markHandled();
            System.out.println("commander handler the request");
        } else {
            super.handleRequest(request);
        }
    }
}
