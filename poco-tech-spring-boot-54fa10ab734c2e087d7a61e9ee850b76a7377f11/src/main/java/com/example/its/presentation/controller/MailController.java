package com.example.its.presentation.controller;


import com.example.its.domain.model.Inquery;
import com.example.its.domain.repository.InqueryRepository;
import com.example.its.domain.service.InqueryService;
import com.example.its.domain.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final InqueryRepository inqueryRepository;
    private final InqueryService inqueryService;


    @GetMapping("/send")
    public String sendMail(@RequestParam String mailaddress, @RequestParam String subject, @RequestParam String text, @RequestParam String id, Model model) {
        Optional.of(mailService).ifPresent(service -> service.Mail(mailaddress, subject, text));
        Optional.of(inqueryRepository).ifPresent(repo -> repo.markAsRead(id));
        return "redirect:/mail/success";
    }

    @GetMapping("/success")
    public String mailSuccess() {
        return "mail/mail-success";
    }

    @GetMapping("/form")
    public String mailForm(@RequestParam long id, Model model) {
        Optional.ofNullable(inqueryService.findById(id))
                .ifPresent(inquery -> model.addAttribute("inquery", inquery));
        return "mail/mailForm";
    }
}
