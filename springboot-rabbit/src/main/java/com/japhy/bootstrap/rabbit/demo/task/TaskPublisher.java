package com.japhy.bootstrap.rabbit.demo.task;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author Japhy
 * @date 2020/2/13 21:06
 *
 *
 */
public class TaskPublisher {

    private static final String QUEUE_NAME = "task-durable";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        final String msg = "im japhy............";
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("succeed");
    }
}
