package com.example.its.domain.service;

import com.example.its.domain.model.User;
import com.example.its.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static org.apache.tomcat.jni.SSL.setPassword;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    HttpSession session;

    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public void create(String username, String password, String authority) {
        var encodedPassword = Optional.ofNullable(password)
                .map(passwordEncoder::encode)
                .orElseThrow(() -> new IllegalArgumentException("Password cannot be null"));
        userRepository.insert(username, encodedPassword, authority);
    }

    @Transactional
    public void updatePassword(String username, String newPassword) {
        userRepository.findByUsername(username).ifPresent(user -> {
            String encodedPassword = passwordEncoder.encode(newPassword);
            userRepository.updatePassword(username, encodedPassword);
        });
    }

    public void setUsername(String username){session.setAttribute("username",username);}
}
