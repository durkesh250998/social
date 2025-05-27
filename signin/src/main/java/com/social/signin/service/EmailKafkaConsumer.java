package com.social.signin.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class EmailKafkaConsumer {


    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "email-group")
    public void consumeEmail(String email) {
        System.out.println("Sending mail to user with email " + email);
    }
}
