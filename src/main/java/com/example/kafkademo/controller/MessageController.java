package com.example.kafkademo.controller;

import com.example.kafkademo.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    /**
     * REST endpoint to publish a message to Kafka
     * @param message The message to be published
     * @return A confirmation message
     */
    @PostMapping
    public String publishMessage(@RequestBody String message) {
        // Send the message to the demo-topic
        messageProducer.sendMessage("demo-topic", message);
        return "Message published successfully";
    }
}
