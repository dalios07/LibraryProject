package com.example.demo.repositories;

import com.example.demo.entites.Book;
import com.example.demo.entites.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);

    Book findByIsbn(String isbn);

    Page<Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
