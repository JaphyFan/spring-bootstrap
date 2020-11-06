package com.japhy.examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.test.context.EmbeddedKafka;

/**
 * @author Japhy
 * @date 2020/3/16 16:33
 */
@SpringBootTest
class KafkaServiceTest {

    @Autowired
    private KafkaService kafkaService;

    @Test
    void sendMessage() {
        kafkaService.sendMessage();
    }

}