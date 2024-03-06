package com.example.demo.dtos;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private int totalCopies;
    private int issuedCopies;
    private String isbn;
    private double price;
    private String categoryName;
    private String authorName;
}
