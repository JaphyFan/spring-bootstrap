package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 10:47
 */
public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (request != null && !request.isHandled()) {
            next.handleRequest(request);
        }
    }
}
