package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "users")  // テーブル名が「users」であればこのアノテーションは任意
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private String password;

    private String authority;

    @Column(name = "is_deleted")
    private Integer isDeleted;

    @Column(name = "created_at")
    private LocalDateTime createdAt;// 作成日時
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;  // 更新日時

    public enum Authority{
        ADMIN,
        USER,
    }

    public User(String username, String password, String authority, Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
