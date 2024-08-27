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

@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final InqueryRepository inqueryRepository;
    private final InqueryService inqueryService;


    @GetMapping("/send")
    public String sendMail(@RequestParam String mailaddress, @RequestParam String subject, @RequestParam String text, @RequestParam String id ,Model model) {
        mailService.Mail(mailaddress, subject, text);
        inqueryRepository.markAsRead(id);
        return "redirect:/mail/success";
    }
    @GetMapping("/success")
    public String mailSuccess() {
        return "mail/mail-success";
    }

    @GetMapping("/form")
    public String mailForm(@RequestParam long id, Model model) {
        Inquery inquery = inqueryService.findById(id);
        model.addAttribute("inquery", inquery);
        return "mail/mailForm";
    }
}
