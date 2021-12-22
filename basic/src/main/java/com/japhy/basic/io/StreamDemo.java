package com.japhy.basic.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * stream 未关闭会导致 file descriptor leak.
 *
 * @author Japhy
 * @since 2021/12/15 14:47
 */
public class StreamDemo {

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0;; i++) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
                    Paths.get("/Users/japhy/Documents/code/bootstrap/java_pid35225.hprof")
                            .toFile()))) {

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
