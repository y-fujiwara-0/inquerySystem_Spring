package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private Authority authority;

    public enum Authority{
        ADMIN,
        USER,
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
