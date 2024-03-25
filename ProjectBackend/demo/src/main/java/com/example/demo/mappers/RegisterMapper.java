package com.example.demo.mappers;

import com.example.demo.dtos.AuthorDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.entites.Author;
import com.example.demo.entites.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper {
    RegisterDto toRegisterDto(User user);
    User toUser(RegisterDto registerDto);
}
