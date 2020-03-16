package com.japhy.examples.demo.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/14 00:41
 */
public class RoutePublisher {

    private static final String EXCHAGE_NAME = "route";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        String msg = "im japhy";
        try ( Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHAGE_NAME, "direct");
            channel.basicPublish(EXCHAGE_NAME, "red", null, (msg + "red").getBytes());
            channel.basicPublish(EXCHAGE_NAME, "green", null, (msg + "green").getBytes());
            channel.basicPublish(EXCHAGE_NAME, "yellow", null, (msg + "yellow").getBytes());
            System.out.println("succeed");
        }
    }

}
