package com.japhy.bootstrap.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.japhy.bootstrap.kafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author Japhy
 * @since 2021/5/14 09:45
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ObjectService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(User user) {
        ListenableFuture send = kafkaTemplate.send("object", user);
    }

    @KafkaListener(topics = "object")
    public void processMessage(String user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user1 = objectMapper.readValue(user, User.class);
        log.info("recv user is {}", user1);
    }

}
