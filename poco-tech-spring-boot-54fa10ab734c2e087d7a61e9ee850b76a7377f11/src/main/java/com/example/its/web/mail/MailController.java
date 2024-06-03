package com.example.its.web.mail;


import com.example.its.domain.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/send")
    public String sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        mailService.Mail(to, subject, text);
        return "redirect:/mail/success";
    }
    @GetMapping("/success")
    public String mailSuccess() {
        return "mail/mail-success";
    }
    @GetMapping("/form")
    public String mailForm() {
        return "mail/mailForm";
    }
}
