package com.example.boldemo.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    private final String serverAddress;
    private final String consumerGroup;

    public KafkaConfig(@Value(value = "${kafka.server-address}") String serverAddress,
                       @Value(value = "${kafka.consumer-group}") String consumerGroup) {
        this.serverAddress = serverAddress;
        this.consumerGroup = consumerGroup;
    }

    @Bean
    public Map<String, Object> kafkaConsumerConfiguration() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
        return properties;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaConsumerConfiguration(), new StringDeserializer(),
                new JsonDeserializer<>(String.class));
    }
}
