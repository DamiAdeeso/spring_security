package com.kint.springsecurity.services;

import com.kint.springsecurity.dto.JwtAuthenticationResponse;
import com.kint.springsecurity.dto.SignInRequest;
import com.kint.springsecurity.dto.SignUpRequest;
import com.kint.springsecurity.entity.User;

public interface AuthenticationService {
     User signUp(SignUpRequest signUpRequest);
     public JwtAuthenticationResponse signIn(SignInRequest signInRequest);
}
