package com.example.its.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailSender mailSender;

    public void Mail(String mailaddress, String subject, String text) {
        var mailInfo = Optional.of(new SimpleMailMessage())
                .map(mail -> {
                    mail.setSubject(subject);
                    mail.setText(text);
                    mail.setTo(mailaddress);
                    mail.setFrom("suzu825193@gmail.com");
                    return mail;
                }).orElseThrow(() -> new IllegalStateException("Failed to create mail message"));

        mailSender.send(mailInfo);
    }
}
