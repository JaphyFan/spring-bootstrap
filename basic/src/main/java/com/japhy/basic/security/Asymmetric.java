package com.japhy.basic.security;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author Japhy
 * @since 2021/2/1 12:51
 */
public class Asymmetric {

    public static void main(String[] args)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException {
        String name = "hello";
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();

        Cipher pri = Cipher.getInstance("RSA");
        pri.init(Cipher.ENCRYPT_MODE, aPrivate);


        Cipher pub = Cipher.getInstance("RSA");
        pub.init(Cipher.DECRYPT_MODE, aPublic);

        byte[] bytes = pri.doFinal(name.getBytes());
        System.out.println(new String(bytes));
        byte[] bytes1 = pub.doFinal(bytes);
        System.out.println(new String(bytes1));

    }
}
