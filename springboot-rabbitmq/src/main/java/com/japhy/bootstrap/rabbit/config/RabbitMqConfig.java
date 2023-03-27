package com.japhy.bootstrap.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2023/3/20 03:02
 */
@Configuration
public class RabbitMqConfig {

    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

}
