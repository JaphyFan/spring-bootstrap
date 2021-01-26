package com.japhy.bootstrap.rabbit.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Japhy
 * @date 2020/2/11 15:35
 */
public class HelloWordPublisher {

    private final static String QUEUE_NAME = "hello_world";

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("39.99.149.197");
        String msg = "hello world, im japhy";
        try (Connection c = connectionFactory.newConnection();
                Channel channel = c.createChannel()){
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            channel.basicPublish("", "demo", null, msg.getBytes());
            channel.basicPublish("", "2", null, msg.getBytes());
            channel.basicPublish("", "3", null, msg.getBytes());
            channel.basicPublish("", "4", null, msg.getBytes());
            System.out.println("succeed ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
