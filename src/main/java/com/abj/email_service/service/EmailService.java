package com.abj.email_service.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String to, String name) {

        System.out.println(">>> Sending email to: " + to);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abj0007@gmail.com");
        message.setTo(to);
        message.setSubject("Welcome to our application!");

        message.setText(
                "Hi " + name + ",\n\n" +
                        "Welcome! Your account has been created successfully.\n\n" +
                        "Regards,\n" +
                        "ABJ"
        );

        mailSender.send(message);

        System.out.println(">>> Email sent successfully to: " + to);
    }
}