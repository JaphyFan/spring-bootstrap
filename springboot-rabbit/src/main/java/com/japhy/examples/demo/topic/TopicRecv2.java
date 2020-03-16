package com.japhy.examples.demo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/14 12:47
 */
public class TopicRecv2 {

    private static final String EXCHANGE_NAME = "topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE_NAME, "com.japhy.*");
        DeliverCallback callback = (consumerTag, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            System.out.println(message.getEnvelope().getRoutingKey() + " routing key ." + msg);
        };

        channel.basicConsume(queue, true, callback, (consumerTag, sig) -> {});
    }

}
