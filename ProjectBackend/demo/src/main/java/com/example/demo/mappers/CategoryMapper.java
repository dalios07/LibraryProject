package com.example.demo.mappers;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.entites.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    CategoryDto toCategoryDto(Category category);
    Category toCategory(CategoryDto categoryDto );

}
