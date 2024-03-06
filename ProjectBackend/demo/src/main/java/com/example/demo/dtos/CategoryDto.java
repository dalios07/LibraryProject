package com.example.demo.dtos;

import com.example.demo.Enums.status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private status status;
    private Date CreationDate;
    private Date UpdatingDate;

}
