package com.example.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    /**
     * Listens to messages from the specified Kafka topic
     * @param message The received message from the topic
     */
    @KafkaListener(topics = "demo-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
    }
}
