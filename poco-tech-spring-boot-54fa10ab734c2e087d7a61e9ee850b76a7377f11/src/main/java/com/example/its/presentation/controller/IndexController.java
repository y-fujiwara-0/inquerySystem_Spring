package com.example.its.presentation.controller;


import com.example.its.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    HttpSession session;
    User user;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
            Optional.ofNullable(session)
                    .filter(s -> s.getAttribute("user") == null)
                    .ifPresent(s -> s.setAttribute("user", user));

            return "index"; // ログイン成功後のページにリダイレクト

    }

    @GetMapping("/logout")
    public String showLogoutForm(HttpServletRequest request) {
        Optional.ofNullable(request.getSession(false))
                .ifPresent(HttpSession::invalidate);

        return "logout";
    }

    @GetMapping("/errorPage")
    public String showErrorPage(){
        return "errorPage";
    }


}


