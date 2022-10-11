package com.japhy.bootstrap.web.infrastructure.helper;

/**
 * @author Japhy
 * @since 2021/1/12 11:14
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8048076401632075353L;

    public ResourceNotFoundException(String id) {
        super("id: " + id + ", resource not found ");
    }
}
