package com.example.its.domain.mail;

import org.springframework.mail.MailSender;

public interface MailRepository {
   MailSender sendMail(String to,String Subject,String Text);
}
