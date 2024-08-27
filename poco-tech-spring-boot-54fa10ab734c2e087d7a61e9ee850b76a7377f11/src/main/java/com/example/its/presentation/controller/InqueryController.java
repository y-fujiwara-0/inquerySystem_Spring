package com.example.its.presentation.controller;

import com.example.its.domain.repository.InqueryRepository;
import com.example.its.domain.model.Inquery;
import com.example.its.domain.service.InqueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/inquery")
@RequiredArgsConstructor
public class InqueryController {
    @Autowired
    private final InqueryService inqueryService;
    private final InqueryRepository inqueryRepository;

    @GetMapping
    public String listInquery(Model model) {
        model.addAttribute("inqueryList", inqueryService.findAll());
        return "inquery/list";
    }

    @GetMapping("/creationForm")
    public String showInqueryForm(Model model) {
        model.addAttribute("inqueryForm", new InqueryForm());
        return "inquery/creationForm";
    }

    @PostMapping
    public String submitInquery(@Valid @ModelAttribute InqueryForm inqueryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "inquery/inqueryForm";
        }//ラムダ式に変更
        Inquery inquery = new Inquery();
        Optional.ofNullable(inqueryForm.getMailAddress()).ifPresent(inquery::setMailAddress);
        Optional.ofNullable(inqueryForm.getName()).ifPresent(inquery::setName);
        Optional.ofNullable(inqueryForm.getOld()).ifPresent(inquery::setOld);
        Optional.ofNullable(inqueryForm.getAddress()).ifPresent(inquery::setAddress);
        Optional.ofNullable(inqueryForm.getClassification()).ifPresent(inquery::setClassification);
        inquery.setDay(Optional.ofNullable(inqueryForm.getDay()).orElseGet(() -> String.valueOf(LocalDate.now())));
        inquery.setUnread(Optional.ofNullable(inqueryForm.getUnread()).orElse("1"));
        Optional.ofNullable(inqueryForm.getBody()).ifPresent(inquery::setBody);
        inqueryService.save(inquery);
        return "redirect:/inquery";
    }

    @GetMapping("/{id}")
    public String getInqueryDetail(@PathVariable Long id, Model model) {
        model.addAttribute("inquery", inqueryService.findById(id));
        return "inquery/detail";
    }

    @GetMapping("/inquery/{id}/read")
    public String markAsRead(@PathVariable Long id) {
        Optional.ofNullable(id)
                .map(inqueryService::findById)
                .ifPresent(inquery -> inqueryRepository.markAsUnread(inquery.getId()));
        return "inquery/list";
    }
}
