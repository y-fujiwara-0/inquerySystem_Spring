package com.example.its.domain.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailSender mailSender;

    public void Mail(String mailaddress, String subject, String text){
        var mailInfo = new SimpleMailMessage();
        mailInfo.setSubject(subject);
        mailInfo.setText(text);
        mailInfo.setTo(mailaddress);
        mailInfo.setFrom("suzu825193@gmail.com");

        mailSender.send(mailInfo);
    }


}
