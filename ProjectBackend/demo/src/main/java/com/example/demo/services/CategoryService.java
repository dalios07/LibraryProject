package com.example.demo.services;

import com.example.demo.Enums.status;
import com.example.demo.dtos.CategoryDto;
import com.example.demo.entites.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<CategoryDto> findAll(Pageable pageable);

    Category findByNameAndStatus(String name);

    Category addCategory(CategoryDto CategoryDto);

    void deleteCategory(Long id);


}
