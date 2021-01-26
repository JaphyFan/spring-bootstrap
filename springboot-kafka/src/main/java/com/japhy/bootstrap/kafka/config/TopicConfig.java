package com.japhy.bootstrap.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Japhy
 * @date 2020/3/16 17:36
 */
@Configuration
public class TopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("demo").partitions(1).replicas(1).compact().build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("topic2").partitions(1).replicas(1).config(
                org.apache.kafka.common.config.TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .compact().build();
    }
}
