package com.japhy.bootstrap.kafka;

import com.japhy.bootstrap.kafka.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author Japhy
 * @date 2020/3/16 15:54
 */
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        User user = new User("japhy", 12L);
        ListenableFuture send = kafkaTemplate.send("demo", message);
    }

    public void recvMessage() {

    }

    @KafkaListener(topics = "demo")
    public void processMessage(String content) {
        System.out.println("--------------- consuming --------------------");
        System.out.println(content);
    }

}
