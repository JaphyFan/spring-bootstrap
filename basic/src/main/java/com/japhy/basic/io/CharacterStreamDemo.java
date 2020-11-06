package com.japhy.basic.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Japhy
 * @since 2020/10/21 15:42
 */
public class CharacterStreamDemo {

    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(
            "/Users/japhy/Documents/code/bootstrap/basic/b.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(
                "/Users/japhy/Documents/code/bootstrap/basic/a.txt"))) {
            String l;
            while ((l = reader.readLine()) != null) {
                writer.println(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end");

    }

}
