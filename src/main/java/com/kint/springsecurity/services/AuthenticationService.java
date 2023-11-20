package com.kint.springsecurity.services;

import com.kint.springsecurity.dto.SignInRequest;
import com.kint.springsecurity.dto.SignUpRequest;
import com.kint.springsecurity.entity.User;
import com.kint.springsecurity.services.impl.SignInResponse;

public interface AuthenticationService {
     User signUp(SignUpRequest signUpRequest);
     public SignInResponse signIn(SignInRequest signInRequest);
}
