package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:32
 */
public class Soldier extends RequestHandler{

    public Soldier(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals("Soldier")) {
            request.markHandled();
            System.out.println("soldier handle the request");
        } else {
            super.handleRequest(request);
        }
    }
}
