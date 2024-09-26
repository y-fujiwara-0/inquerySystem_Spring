package com.example.its.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.seasar.doma.Column;
import org.seasar.doma.Id;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquery{


    Long inqueryId;

    String mailAddress;

    String name;

    Integer age;

    String address;

    String classification;

    LocalDateTime registrationAt;

    LocalDateTime replyAt;

    String isReaded;

    String content;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

//    public Inquery(){
//    }
//
//    public Inquery(String mailAddress, String name, Integer age, String address, String classification,
//                   LocalDateTime registrationAt, LocalDateTime replyAt, String isReaded,
//                   String content ,LocalDateTime createdAt, LocalDateTime updatedAt) {
//        this.mailAddress = mailAddress;
//        this.name = name;
//        this.age = age;
//        this.address = address;
//        this.classification = classification;
//        this.registrationAt = registrationAt;
//        this.replyAt = replyAt;
//        this.isReaded = isReaded;
//        this.content = content;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }

}
