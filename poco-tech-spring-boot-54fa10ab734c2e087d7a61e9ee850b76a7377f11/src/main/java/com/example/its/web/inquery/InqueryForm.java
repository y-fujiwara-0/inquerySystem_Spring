package com.example.its.web.inquery;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class InqueryForm {
    @NotEmpty
    @Size(max = 50)
    private String mailAddress;

    @NotEmpty
    @Size(max = 30)
    private String name;

    @NotEmpty
    @Size(max = 3)
    private String old;

    @NotEmpty
    @Size(max = 200)
    private String address;

    @NotEmpty
    @Size(max = 100)
    private String classification;

    @NotEmpty
    @Size(max = 50)
    private String day;

    @NotEmpty
    private String unread;

    @NotEmpty
    @Size(max = 1000)
    private String body;
}
