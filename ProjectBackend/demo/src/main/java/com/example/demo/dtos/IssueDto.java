package com.example.demo.dtos;

import com.example.demo.entites.Book;
import com.example.demo.entites.Student;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
    private Long id;
    private int fine;
    private Date CreationDate;
    private Date returnDate;
    private String isbn;
    private String bookName;
    private Long studentId;
    private String studentName;
}
