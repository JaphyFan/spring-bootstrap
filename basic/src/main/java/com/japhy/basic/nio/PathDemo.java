package com.japhy.basic.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Japhy
 * @since 2020/10/22 11:22
 */
public class PathDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/japhy/Documents/code/bootstrap/basic/b.txt");
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isReadable(path));
        File x = path.toFile();
        System.out.println(x.getName());
        BasicFileAttributes basicFileAttributes =
            Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(basicFileAttributes.lastAccessTime());

    }
}
