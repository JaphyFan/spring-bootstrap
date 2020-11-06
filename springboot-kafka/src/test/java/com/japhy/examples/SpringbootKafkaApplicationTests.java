package com.japhy.examples;

import java.time.Duration;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
@EmbeddedKafka(topics = "testTopic")
class SpringbootKafkaApplicationTests {

    @Autowired
    private Consumer consumer;

    @Autowired
    private Producer producer;

    @Test
    void testExchange() {
        Awaitility.waitAtMost(Duration.ofSeconds(30));
    }

    @Test
    void contextLoads() {
    }

}
