package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {
    private String mailaddress;
    private String subject;
    private String text;

    public Mail(){

    }

}
