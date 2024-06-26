package com.example.demo.services;

import com.example.demo.dtos.BookDto;
import com.example.demo.entites.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    Book findByIsbn(String isbn);

    Page<BookDto> searchBooks(String name, Pageable pageable);

    Book addBook(BookDto BookDto);

    void deleteBook(Long id);

    void EditBook(int nb, Book book);
}
