package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 10:55
 */
public class Officer extends RequestHandler{

    public Officer(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.OFFICER) {
            request.setHandled(true);
            System.out.println("officer handle the request" + request);
        } else {
            super.handleRequest(request);
        }
    }
}
