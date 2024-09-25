package com.example.its.presentation.controller;

import com.example.its.domain.model.Inquery;
import com.example.its.domain.model.Users;
import com.example.its.domain.repository.UserRepository;
import com.example.its.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    @GetMapping("/search")
    public String user_search(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "authority", required = false) String authority,
                              Model model) {
        // サービスを使って問い合わせを検索
        List<Users> users = userService.user_search(username, authority);
        // モデルに検索結果を追加
        model.addAttribute("userList", users);
        // 問い合わせ一覧ページを返す
        return "users/list";  // 問い合わせ一覧ページのビュー名
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

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("username") String username) {
//        userRepository.updateDeleteFlag(username, true);
        return "redirect:/users"; // ユーザー一覧ページにリダイレクト
    }

}
