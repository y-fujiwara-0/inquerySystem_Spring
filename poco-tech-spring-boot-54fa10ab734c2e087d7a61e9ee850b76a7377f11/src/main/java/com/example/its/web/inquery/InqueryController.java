package com.example.its.web.inquery;

import org.apache.ibatis.annotations.Mapper;
import com.example.its.domain.inquery.Inquery;
import com.example.its.domain.inquery.InqueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/inquery")
@RequiredArgsConstructor
public class InqueryController {
    @Autowired
    private final InqueryService inqueryService;

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
        }
        Inquery inquery = new Inquery();
        inquery.setMailAddress(inqueryForm.getMailAddress());
        inquery.setName(inqueryForm.getName());
        inquery.setOld(inqueryForm.getOld());
        inquery.setAddress(inqueryForm.getAddress());
        inquery.setClassification(inqueryForm.getClassification());
        inquery.setDay(inqueryForm.getDay() != null ? inqueryForm.getDay() : String.valueOf(LocalDate.now()));
        inquery.setUnread(inqueryForm.getUnread() != null ? inqueryForm.getUnread() : "1");
        inquery.setBody(inqueryForm.getBody());
        inqueryService.save(inquery);
        return "redirect:/inquery";
    }

    @GetMapping("/{id}")
    public String getInqueryDetail(@PathVariable Long id, Model model) {
        model.addAttribute("inquery", inqueryService.findById(id));
        return "inquery/detail";
    }

    @PostMapping("/inquery/{id}/read")
    public String markAsRead(@PathVariable("inqueryId") Long id) {
        inqueryService.findById(id);
        inqueryService.markAsRead(id);
        return "redirect:/inquery";
    }
}
