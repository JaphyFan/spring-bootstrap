package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:30
 */
public class Officer extends RequestHandler{

    public Officer(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals("Officer")) {
            request.markHandled();
            System.out.println("officer handle the request");
        } else {
            super.handleRequest(request);
        }
    }
}
