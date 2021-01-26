package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 10:51
 */
public class Solider extends RequestHandler{

    public Solider(RequestHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.SOLIDER) {
            request.setHandled(true);
            System.out.println("Solider handle the request" + request);
        } else {
            super.handleRequest(request);
        }
    }
}
