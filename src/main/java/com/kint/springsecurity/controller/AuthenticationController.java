package com.kint.springsecurity.controller;

import com.kint.springsecurity.dto.JwtAuthenticationResponse;
import com.kint.springsecurity.dto.SignInRequest;
import com.kint.springsecurity.dto.SignUpRequest;
import com.kint.springsecurity.entity.User;
import com.kint.springsecurity.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));

    }

    @PostMapping("/signin")
        public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signinRequest){

            return ResponseEntity.ok(authenticationService.signIn(signinRequest));
        }

}

