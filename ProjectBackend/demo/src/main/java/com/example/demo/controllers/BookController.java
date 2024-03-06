package com.example.demo.controllers;

import com.example.demo.dtos.BookDto;
import com.example.demo.entites.Book;
import com.example.demo.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Book")
@AllArgsConstructor
public class BookController {


    private final BookService bookService;
    @GetMapping

    public Page<BookDto> Getall(Pageable pageable)
    {

        return(bookService.findAll(pageable));

    }

    @PostMapping

    public Book Add(@RequestBody BookDto BookDto)
    {

        return(bookService.addBook(BookDto));

    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id)
    {
        bookService.deleteBook(id);
    }
}

