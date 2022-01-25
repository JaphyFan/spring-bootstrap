package com.japhy.cloud.common.exceptions;

/**
 * @author Japhy
 * @since 2022/1/18 13:14
 */
public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = -5524209098594204641L;

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
