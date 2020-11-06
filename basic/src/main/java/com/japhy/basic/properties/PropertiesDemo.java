package com.japhy.basic.properties;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author Japhy
 * @since 2020/10/30 11:11
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Properties properties = new Properties();
        InputStream resourceAsStream =
            PropertiesDemo.class.getClassLoader().getResourceAsStream("a.txt");
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("a"));
        if (resourceAsStream != null) {
            resourceAsStream.close();
        }

        URL resource = PropertiesDemo.class.getClassLoader().getResource("b.txt");
        OutputStream outputStream = Files.newOutputStream(Paths.get(resource.toURI()));
        properties.setProperty("d", "4");
        properties.store(outputStream, "haha");
        outputStream.close();
        System.out.println("outputStream closed");

    }

}
