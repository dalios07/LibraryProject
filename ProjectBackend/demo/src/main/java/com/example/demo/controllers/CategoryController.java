package com.example.demo.controllers;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.entites.Category;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Category")
@AllArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;
    @GetMapping

    public Page<CategoryDto> Getall(Pageable pageable)
    {

        return(categoryService.findAll(pageable));

    }
    @GetMapping("/{id}")

    public Category GetById(@PathVariable("id") Long id)
    {

        return(categoryService.findById(id));

    }
    @GetMapping("/search")

    public Page<CategoryDto> search(@RequestParam("name") String name,Pageable pageable)
    {

        return(categoryService.searchCategorys(name,pageable));

    }

    @PostMapping

    public Category Add(@RequestBody CategoryDto CategoryDto)
    {

        return(categoryService.addCategory(CategoryDto));

    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") Long id)
    {
        categoryService.deleteCategory(id);
    }
}
