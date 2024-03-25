package com.example.demo.services;

import com.example.demo.dtos.AuthenticationRequest;
import com.example.demo.dtos.AuthenticationResponse;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.entites.User;

public interface AuthenticationService {
    User Register(RegisterDto registerDto);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    User getUserByToken(String token);
}
