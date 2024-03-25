package com.example.demo.mappers;


import com.example.demo.dtos.AuthorDto;
import com.example.demo.entites.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toAuthorDto(Author author);
    Author toAuthor(AuthorDto authorDto );
}
