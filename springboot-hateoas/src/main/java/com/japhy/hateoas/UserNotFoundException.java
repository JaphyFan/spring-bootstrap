package com.japhy.hateoas;

/**
 * @author Japhy
 * @since 2021/1/12 12:53
 */
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 8796305250149888714L;

    public UserNotFoundException(Long id) {
        super("id:" + id + " not found !");
    }
}
