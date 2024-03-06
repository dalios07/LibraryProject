package com.example.demo.controllers;

import com.example.demo.dtos.AuthorDto;
import com.example.demo.entites.Author;
import com.example.demo.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Author")
@AllArgsConstructor
public class AuthorController {


    private final AuthorService autherService;
    @GetMapping

    public Page<AuthorDto> Getall(Pageable pageable)
    {

        return(autherService.findAll(pageable));

    }

    @PostMapping

    public Author Add(@RequestBody AuthorDto AuthorDto)
    {

        return(autherService.addAuthor(AuthorDto));

    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id)
    {
        autherService.deleteAuthor(id);
    }
}

