package com.kint.springsecurity.services.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kint.springsecurity.dto.JwtAuthenticationResponse;
import com.kint.springsecurity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignInResponse {

    private final User user;

    private final JwtAuthenticationResponse jwtAuthenticationResponse;
}
