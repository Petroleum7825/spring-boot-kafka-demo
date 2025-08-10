package com.example.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Sends a message to the specified Kafka topic
     * @param topic The Kafka topic to send the message to
     * @param message The message content to be sent
     */
    public void sendMessage(String topic, String message) {
        // Using KafkaTemplate to send the message to the specified topic
        kafkaTemplate.send(topic, message);
    }
}
