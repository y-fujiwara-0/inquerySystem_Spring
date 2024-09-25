package com.example.its.domain.service;

import com.example.its.domain.model.Inquery;
import com.example.its.domain.model.Users;
import com.example.its.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    HttpSession session;

    //ユーザー一覧検索
    @PreAuthorize("hasAuthority('1')")
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    //ユーザー新規作成
    @PreAuthorize("hasAuthority('1')")
    public Users create(String username, String password, String authority) {
        // パスワードの検証とエンコード
        String encodedPassword = Optional.ofNullable(password)
                .map(passwordEncoder::encode)
                .orElseThrow(() -> new IllegalArgumentException("Password cannot be null"));

        // 現在時刻を作成日時と更新日時として使用
        LocalDateTime now = LocalDateTime.now();

        // ユーザーオブジェクトを作成
        Users users = new Users(
                null,       // ユーザーID
                username,      // ユーザー名
                encodedPassword,// パスワード
                authority,     // 権限
                0,             // isDeleted（0は削除されていないことを意味する）
                now,           // 作成日時
                now            // 更新日時
        );

        // ユーザーを挿入
        userRepository.insert(users);
        return users;
    }

    //ユーザーアップデート
    @Transactional
    public void updatePassword(String username, String password) {
        // ユーザーを取得
        Optional<Users> optionalUser = userRepository.findByUsernameAndDeleteflagFalse(username);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            // パスワードをエンコード
            String encodedPassword = passwordEncoder.encode(password);
            // 新しいUserオブジェクトを作成してパスワードを更新
            Users updatedUsers = new Users(
                    users.getUserId(),          // 既存のuserId
                    users.getUsername(),        // 既存のusername
                    encodedPassword,           // エンコードされた新しいパスワード
                    users.getAuthority(),       // 既存のauthority
                    users.getIsDeleted(),       // 既存のisDeleted
                    users.getCreatedAt(),       // 既存のcreatedAt
                    LocalDateTime.now()        // 更新日時を現在の時間に設定
            );
            // 更新処理
            userRepository.updatePassword(updatedUsers);
        }
    }

    public void setUsername(String username){session.setAttribute("username",username);}


    public List<Users> user_search(@Param("username") String username, @Param("authority") String authority) {
        return userRepository.user_search(username, authority);
    }
}
