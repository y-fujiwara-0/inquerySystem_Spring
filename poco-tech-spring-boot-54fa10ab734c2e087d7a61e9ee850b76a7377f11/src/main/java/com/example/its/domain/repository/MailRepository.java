package com.example.its.domain.repository;

import org.springframework.mail.MailSender;

public interface MailRepository {
   MailSender sendMail(String mailaddress,String Subject,String Text);
}
