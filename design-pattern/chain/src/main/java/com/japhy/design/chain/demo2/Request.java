package com.japhy.design.chain.demo2;

/**
 * @author Japhy
 * @since 2021/1/26 10:44
 */
public class Request {

    private RequestType type;

    private boolean isHandled;

    public Request(RequestType type) {
        this.type = type;
    }

    public boolean isHandled() {
        return isHandled;
    }

    public void setHandled(boolean handled) {
        isHandled = handled;
    }

    public String getDescription() {
        return this.toString();
    }

    public RequestType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Request{" +
            "type=" + type +
            ", isHandled=" + isHandled +
            '}';
    }
}
