package com.abj.email_service.event;

import com.abj.email_service.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserCreatedConsumer {

    private final EmailService emailService;

    public UserCreatedConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(
            topics = "user-created",
            groupId = "email-service-group"
    )
    public void consume(UserCreatedEvent event) {

        System.out.println("=================================");
        System.out.println("New User Created!");
        System.out.println("User ID : " + event.getUserId());
        System.out.println("Name    : " + event.getName());
        System.out.println("Email   : " + event.getEmail());
        System.out.println("=================================");

        emailService.sendWelcomeEmail(
                event.getEmail(),
                event.getName()
        );
    }
}