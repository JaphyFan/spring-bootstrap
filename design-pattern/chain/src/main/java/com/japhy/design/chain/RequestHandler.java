package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:24
 */
public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
