package com.example.its.domain.inquery;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Inquery{
    private Long id;
    private String mailAddress;
    private String name;
    private String old;
    private String address;
    private String classification;
    private String day;
    private String unread;
    private String body;

    public Inquery(){
    }

    public Inquery(String mailAddress, String name, String old, String address, String classification, String day, String unread, String body) {
        this.mailAddress = mailAddress;
        this.name = name;
        this.old = old;
        this.address = address;
        this.classification = classification;
        this.day = day;
        this.unread = unread;
        this.body = body;
    }

}
