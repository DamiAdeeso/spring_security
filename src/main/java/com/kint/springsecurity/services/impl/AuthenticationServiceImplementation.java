package com.kint.springsecurity.services.impl;

import com.kint.springsecurity.dto.JwtAuthenticationResponse;
import com.kint.springsecurity.dto.SignInRequest;
import com.kint.springsecurity.dto.SignUpRequest;
import com.kint.springsecurity.entity.Role;
import com.kint.springsecurity.entity.User;
import com.kint.springsecurity.repository.UserRepository;
import com.kint.springsecurity.services.AuthenticationService;
import com.kint.springsecurity.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;


    public User signUp(SignUpRequest signUpRequest){
        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstName((signUpRequest.getFirstName()));
        user.setSecondName(signUpRequest.getSecondName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);
        return user;
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest){
        authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword())));

        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid Email or password"));
        System.out.println("here" + user);
        var jwt = jwtService.generateToken(user);

        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshtoken(refreshToken);

        return jwtAuthenticationResponse;
    }

}
