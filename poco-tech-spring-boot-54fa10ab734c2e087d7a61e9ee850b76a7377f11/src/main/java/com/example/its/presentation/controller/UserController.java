package com.example.its.presentation.controller;

import com.example.its.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute UserForm userForm) {
        return "users/creationForm";
    }

    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        userService.create(form.getUsername(), form.getPassword(), form.getAuthority());
        return "redirect:/users";
    }
    @PostMapping("/{username}/password")
    public String updatePassword(@PathVariable String username,
                                 @RequestParam("Password") String Password) {
        userService.updatePassword(username, Password);
        return "redirect:/login";  // パスワード変更後にログインページにリダイレクト
    }

    @GetMapping("/passwordForm")
    public String showPasswordUpdateForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Runnable addAttributes = () -> {
            model.addAttribute("user", authentication.getPrincipal());
            model.addAttribute("username", authentication.getName());
        };
        addAttributes.run(); // 属性設定実行
        return "users/passwordForm";
    }
}
