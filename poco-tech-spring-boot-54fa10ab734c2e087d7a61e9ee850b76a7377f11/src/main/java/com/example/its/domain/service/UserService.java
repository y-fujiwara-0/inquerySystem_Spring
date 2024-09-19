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

    @PreAuthorize("hasAuthority('1')")
    public void create(String username, String password, String authority) {
        // パスワードの検証とエンコード
        String encodedPassword = Optional.ofNullable(password)
                .map(passwordEncoder::encode)
                .orElseThrow(() -> new IllegalArgumentException("Password cannot be null"));

        User.Authority userAuthority;
        try {
            userAuthority = User.Authority.valueOf(authority);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid authority value: " + authority);
        }
        // ユーザーオブジェクトを作成
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setAuthority(authority);

        // ユーザーを挿入
        userRepository.insert(user);
    }

    @Transactional
    public void updatePassword(String username, String password) {
        // ユーザーを取得
        Optional<User> optionalUser = userRepository.findByUsernameAndDeleteflagFalse(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // パスワードをエンコード
            String encodedPassword = passwordEncoder.encode(password);
            // エンティティのパスワードを更新
            user.setPassword(encodedPassword);
            // 更新処理
            userRepository.updatePassword(user);
        }
    }

    public void setUsername(String username){session.setAttribute("username",username);}

    //パスワードアップデートするときにセッションデータを取得するコードをかく
}
