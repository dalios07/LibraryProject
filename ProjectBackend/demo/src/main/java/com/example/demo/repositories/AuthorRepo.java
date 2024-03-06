package com.example.demo.repositories;

import com.example.demo.entites.Author;
import com.example.demo.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    boolean existsByName(String name);

    Author findByName(String name);
}
