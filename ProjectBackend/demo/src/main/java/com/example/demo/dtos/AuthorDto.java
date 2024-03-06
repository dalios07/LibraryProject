package com.example.demo.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private Date CreationDate;
    private Date UpdatingDate;
}
