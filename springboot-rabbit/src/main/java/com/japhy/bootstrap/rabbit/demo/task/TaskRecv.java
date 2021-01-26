package com.japhy.bootstrap.rabbit.demo.task;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Japhy
 * @date 2020/2/13 21:11
 * 1. message acknowledgement
 * 2. message durability
 * 3. fair dispatch
 */
public class TaskRecv {

    private static final String QUEUE_NAME = "task-durable";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.99.149.197");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // message durability
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 设置每个worker 接收的最大消息数
        channel.basicQos(1);
        // 设置消息自动确认是否打开
        boolean autoAck = false;
        DeliverCallback callback = (consumerTag, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            doWork(msg);
            // 设置消息确认
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
            System.out.println(msg + " done");
        };
        channel.basicConsume(QUEUE_NAME, autoAck, callback, consumerTag -> {});
    }

    private static void doWork(String msg) {
        for (char ch : msg.toCharArray()) {
            System.out.print(ch);
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
