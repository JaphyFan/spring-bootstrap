package com.japhy.cloud.common.exceptions;

/**
 * @author Japhy
 * @since 2022/1/18 13:12
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1412316645723190093L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
