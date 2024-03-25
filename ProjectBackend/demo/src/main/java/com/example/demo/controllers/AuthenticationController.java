package com.example.demo.controllers;

import com.example.demo.dtos.AuthenticationRequest;
import com.example.demo.dtos.AuthenticationResponse;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.entites.User;
import com.example.demo.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/register")
    public User register(@RequestBody RegisterDto request) {
        return (service.Register(request));
    }
    @PostMapping
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return service.authenticate(request);
    }
    @GetMapping
    public User getUserByToken(@RequestParam String token)
    {
        return service.getUserByToken(token);
    }

}
