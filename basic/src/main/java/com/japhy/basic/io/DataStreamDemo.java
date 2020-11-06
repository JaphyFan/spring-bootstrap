package com.japhy.basic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Japhy
 * @since 2020/10/21 16:52
 */
public class DataStreamDemo {

    static final double[] prices = {1, 2, 5.44, 2.44};

    static final String[] descs = {"gread", "shirt", "adkf", "djgg"};

    public static void main(String[] args) throws IOException {

        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream("/Users/japhy/Documents/code/bootstrap/basic/c.txt")))) {
            for (int i = 0, pricesLength = prices.length; i < pricesLength; i++) {
                out.writeDouble(prices[i]);
                out.writeUTF(descs[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DataInputStream input = new DataInputStream(new BufferedInputStream(
            new FileInputStream("/Users/japhy/Documents/code/bootstrap/basic/c.txt")))) {
            while (true) {
                double v = input.readDouble();
                String s = input.readUTF();
                System.out.format("desc: %s ; and price; %.2f %n", s, v);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
    }

}
