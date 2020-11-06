package com.japhy.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Japhy
 * @since 2020/10/21 10:36
 */
public class ByteStreamDemo {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        try (FileInputStream in = new FileInputStream("/Users/japhy/Documents/code/bootstrap/basic/a.txt");
            FileOutputStream out = new FileOutputStream("/Users/japhy/Documents/code/bootstrap/basic/b.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
