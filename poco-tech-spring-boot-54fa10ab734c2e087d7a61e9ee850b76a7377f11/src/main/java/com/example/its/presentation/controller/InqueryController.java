package com.example.its.presentation.controller;

import com.example.its.domain.repository.InqueryRepository;
import com.example.its.domain.model.Inquery;
import com.example.its.domain.service.InqueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
        Optional.ofNullable(inqueryForm.getMailAddress()).ifPresent(inquery::setMail_Address);
        Optional.ofNullable(inqueryForm.getName()).ifPresent(inquery::setName);
        Optional.ofNullable(inqueryForm.getOld())
                .filter(old -> !old.isEmpty())  // 空文字を除外
                .ifPresent(old -> {
                    try {
                        int age = Integer.parseInt(old);  // StringをIntegerに変換
                        inquery.setAge(age);
                    } catch (NumberFormatException e) {
                        // 変換に失敗した場合の処理（例: ログ出力）
                        System.err.println("Invalid number format: " + old);
                    }
                });
        Optional.ofNullable(inqueryForm.getAddress()).ifPresent(inquery::setAddress);
        Optional.ofNullable(inqueryForm.getClassification()).ifPresent(inquery::setClassification);
        inquery.setRegistration_At(LocalDateTime.parse(Optional.ofNullable(inqueryForm.getDay()).orElseGet(() -> String.valueOf(LocalDate.now()))));
        inquery.setIs_readed(Optional.ofNullable(inqueryForm.getUnread()).orElse("1"));
        Optional.ofNullable(inqueryForm.getBody()).ifPresent(inquery::setContent);
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
                .ifPresent(inquery -> inqueryRepository.markAsUnread(inquery.getInquery_id()));
        return "inquery/list";
    }

    @GetMapping("/search")
    public String inquery_search(@RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
                                 Model model) {
        // サービスを使って問い合わせを検索
        List<Inquery> inqueries = inqueryService.inquery_search(keyword, dateFrom, dateTo);

        // モデルに検索結果を追加
        model.addAttribute("inqueryList", inqueries);

        // 問い合わせ一覧ページを返す
        return "inquery/list";  // 問い合わせ一覧ページのビュー名
    }
}
