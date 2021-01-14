package com.japhy.basic.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Japhy
 * @since 2020/10/21 16:40
 */
public class ScannerDemo {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner s = new Scanner(new BufferedReader(
            new FileReader("/Users/japhy/Documents/code/bootstrap/basic/a.txt")))) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
