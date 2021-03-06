package com.japhy.bootstrap.rabbit.demo.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/14 00:53
 */
public class RouteRecv {

    private static final String EXCHANGE_NAME = "route";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queue1 = channel.queueDeclare().getQueue();
        String queue2 = channel.queueDeclare().getQueue();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        channel.queueBind(queue1, EXCHANGE_NAME, "red");
        channel.queueBind(queue1, EXCHANGE_NAME, "yellow");

        DeliverCallback callback = (consumerTag, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            System.out.println(msg + message.getEnvelope().getRoutingKey());
        };

        channel.basicConsume(queue1, true, callback, (consumerTag, sig) -> {});
    }

}
