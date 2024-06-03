package com.example.its.web.mail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MailForm {

    @NotEmpty
    @Size(max = 50)
    private String to;

    @NotEmpty
    @Size(max = 100)
    private String subject;

    @NotEmpty
    @Size(max = 1000)
    private String text;
}
