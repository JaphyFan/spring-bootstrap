package com.japhy.bootstrap.rabbit.demo.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/13 23:48
 */
public class PubDemo {

    private static final String EXCHANGE_NAME = "multiple";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            String msg = "im japhy";
            channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
        }
    }
}
