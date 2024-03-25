package com.example.demo.dtos;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String name;
    private String password;

}
