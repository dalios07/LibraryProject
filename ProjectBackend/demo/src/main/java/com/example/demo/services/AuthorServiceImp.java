package com.example.demo.services;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dtos.AuthorDto;
import com.example.demo.entites.Author;
import com.example.demo.mappers.AuthorMapper;
import com.example.demo.repositories.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImp implements AuthorService {


    private final AuthorRepo authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Page<AuthorDto> findAll(Pageable pageable) {
        Page<Author> authors = authorRepository.findAll(pageable);

        return authors.map(author -> authorMapper.toAuthorDto(author));
    }

    @Override
    public Author findByName(String name)
    {
        if (!authorRepository.existsByName(name)) {
            throw new ResourceNotFoundException("Author not found with name " + name);}
        return authorRepository.findByName(name);
    }

    @Override
    public Author addAuthor(AuthorDto AuthorDto) {

        return (authorRepository.save(authorMapper.toAuthor(AuthorDto)));
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
    }

}

