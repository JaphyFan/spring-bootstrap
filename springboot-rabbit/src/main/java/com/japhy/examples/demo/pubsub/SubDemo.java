package com.japhy.examples.demo.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/13 23:57
 */
public class SubDemo {

    private static final String EXCHANGE_NAME = "multiple";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queue = channel.queueDeclare().getQueue();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        channel.queueBind(queue, EXCHANGE_NAME, "");

        DeliverCallback callback = (consumerTag, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            System.out.println(msg);
        };
        channel.basicConsume(
                "", false, "", callback, (consumerTag, sig) -> { });

    }

}
