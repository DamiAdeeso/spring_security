package com.kint.springsecurity.controller;

import com.kint.springsecurity.dto.JwtAuthenticationResponse;
import com.kint.springsecurity.dto.SignInRequest;
import com.kint.springsecurity.dto.SignUpRequest;
import com.kint.springsecurity.entity.User;
import com.kint.springsecurity.services.AuthenticationService;
import com.kint.springsecurity.services.impl.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));

    }

    @PostMapping("/signin")
        public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signinRequest){

            return ResponseEntity.ok(authenticationService.signIn(signinRequest));
        }

}

