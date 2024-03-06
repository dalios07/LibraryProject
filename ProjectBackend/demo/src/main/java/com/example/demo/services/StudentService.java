package com.example.demo.services;

import com.example.demo.entites.Student;

import java.util.Optional;

public interface StudentService {
    Student findById(Long id);
}
