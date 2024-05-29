package com.example.its.web.inquery;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @NotNull
    private LocalDate today = LocalDate.now();
    String day = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @NotEmpty
    private String unread = "1";

    @NotEmpty
    @Size(max = 1000)
    private String body;
}
