package com.example.its.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "users")
@Data
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private final Long userId;
    private final String username;
    private final String password;
    private final String authority;

    @Column(name = "is_deleted")
    private final Integer isDeleted;

    @Column(name = "created_at")
    private final LocalDateTime createdAt;

    @Column(name = "updated_at")
    private final LocalDateTime updatedAt;

    public Users(Long userId, String username, String password, String authority, Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = null;  // オートインクリメントにより、自動で設定
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
