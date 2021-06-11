package com.japhy.bootstrap.kafka.config;

import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * @author Japhy
 * @since 2021/5/14 09:46
 */
@Configuration
@EnableKafka
public class KafkaConfig {

//    @Value("${spring.kafka.bootstrap-servers}")
//    private String kafkaServers;
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = Maps.newHashMap();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<String, Object> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
