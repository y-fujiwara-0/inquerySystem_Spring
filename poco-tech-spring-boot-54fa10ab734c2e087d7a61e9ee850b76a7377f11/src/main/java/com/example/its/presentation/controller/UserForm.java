package com.example.its.presentation.controller;

import com.example.its.presentation.Validation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank
    @UniqueUsername
    private String username;

    @NotBlank
    @Size(min = 12, max = 128)
    private String password;

    @NotBlank
    private String authority;
}