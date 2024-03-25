package com.example.demo.services;

import com.example.demo.dtos.AuthorDto;
import com.example.demo.entites.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    Page<AuthorDto> findAll(Pageable pageable);

    Author findById(Long id);

    Author findByName(String name);

    Page<AuthorDto> searchAuthors(String name, Pageable pageable);

    Author addAuthor(AuthorDto AuthorDto);

    void deleteAuthor(Long id);
}
