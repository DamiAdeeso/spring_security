package com.kint.springsecurity.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private Long userid;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phonenumber;

}
