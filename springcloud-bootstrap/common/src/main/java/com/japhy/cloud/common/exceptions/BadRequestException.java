package com.japhy.cloud.common.exceptions;

/**
 * @author Japhy
 * @since 2022/1/18 13:14
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -7840879049434271817L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
