package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.seasar.doma.Column;
import org.seasar.doma.Id;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class Inquery{

    @Id
    @Column(name = "inquery_id")
    private Long inquery_id;

    private String mail_Address;

    private String name;

    private Integer age;

    private String address;

    private String classification;

    private LocalDateTime registration_At;

    private LocalDateTime reply_At;

    private String is_readed;

    private String content;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public Inquery(){
    }

    public Inquery(String mail_Address, String name, Integer age, String address, String classification,
                   LocalDateTime registration_At, LocalDateTime reply_At, String is_readed,
                   String content ,LocalDateTime created_at, LocalDateTime updated_at) {
        this.mail_Address = mail_Address;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classification = classification;
        this.registration_At = registration_At;
        this.reply_At = reply_At;
        this.is_readed = is_readed;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
