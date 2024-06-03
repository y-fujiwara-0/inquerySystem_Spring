package com.example.its.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {
    private String to;
    private String subject;
    private String text;

    public Mail(){

    }

}
