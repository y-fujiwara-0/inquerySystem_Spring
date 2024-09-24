package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//sampleを見ながら作成
public class Users {
    /** ユーザーID */
    Long userId;
    /** ユーザー名 */
    String username;
    /** パスワード*/
    String password;
    /** 権限 */
    String authority;
    /** 削除フラグ */
    Integer isDeleted;
    /** 作成日時 */
    LocalDateTime createdAt;
    /** 更新日時 */
    LocalDateTime updatedAt;
}
