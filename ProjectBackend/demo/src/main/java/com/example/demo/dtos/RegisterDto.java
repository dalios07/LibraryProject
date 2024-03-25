package com.example.demo.dtos;

import com.example.demo.Enums.Role;
import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
    private boolean enabled;
}
