package com.japhy.design.chain;

/**
 * @author Japhy
 * @since 2020/11/17 16:10
 */
public class Request {

    private boolean handled;

    private String requestType;

    public Request(String requestType) {
        this.requestType = requestType;
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    public String getRequestType() {
        return requestType;
    }
}
