package com.example.demo.repositories;

import com.example.demo.Enums.status;
import com.example.demo.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    boolean existsByName(String name);

    Category findByNameAndStatus(String name,status status);

    boolean existsByNameAndStatus(String name, status status);
}
