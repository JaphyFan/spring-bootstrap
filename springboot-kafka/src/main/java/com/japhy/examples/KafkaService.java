package com.japhy.examples;

import com.japhy.examples.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author Japhy
 * @date 2020/3/16 15:54
 */
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage() {
        User user = new User("japhy", 12L);
        ListenableFuture send = kafkaTemplate.send("demo", user);
    }

    public void recvMessage() {

    }

    @KafkaListener(topics = "demo")
    public void processMessage(String content) {
        System.out.println("--------------- consuming --------------------");
        System.out.println(content);
    }

}
