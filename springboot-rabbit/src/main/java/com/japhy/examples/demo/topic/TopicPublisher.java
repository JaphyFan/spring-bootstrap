package com.japhy.examples.demo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/14 12:34
 * demonstrate a topic exchange
 * topic 发送时指明routing key, 接收时正则routing key
 *
 */
public class TopicPublisher {

    private static final String EXCHANGE_NAME = "topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        String msg = "hello";
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            channel.basicPublish(EXCHANGE_NAME, "com.japhy.title", null, msg.getBytes());
            channel.basicPublish(EXCHANGE_NAME, "com.grant.title", null, msg.getBytes());
            channel.basicPublish(EXCHANGE_NAME, "com.japhy.examples", null, msg.getBytes());
        }
        System.out.println("succeed");
    }

}
