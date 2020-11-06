package com.japhy.springsecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Japhy
 * @since 2020/4/13 13:26
 */
public class PasswordDemo {

    public static void main(String[] args) {
        PasswordEncoder delegatingPasswordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String fanjh = delegatingPasswordEncoder.encode("fanjh");
        System.out.println(fanjh);
        boolean b = delegatingPasswordEncoder.upgradeEncoding(fanjh);
        System.out.println(b);

        boolean fanjh1 = delegatingPasswordEncoder.matches("fanjh", fanjh);
        System.out.println(fanjh1);
        User.withDefaultPasswordEncoder().username("admin").password("admin").roles("admin").build();

        PasswordEncoder instance = NoOpPasswordEncoder.getInstance();
        String admin = instance.encode("admin");
        System.out.println(admin);
    }

}
