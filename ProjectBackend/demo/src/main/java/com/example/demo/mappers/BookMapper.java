package com.example.demo.mappers;

import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.CategoryDto;
import com.example.demo.entites.Book;
import com.example.demo.entites.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(Book book);
    Book toBook(BookDto bookDto );
}
