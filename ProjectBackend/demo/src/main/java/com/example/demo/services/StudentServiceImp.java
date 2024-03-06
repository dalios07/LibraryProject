package com.example.demo.services;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.entites.Student;
import com.example.demo.repositories.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService{
    private final StudentRepo studentRepository;
    @Override
    public Student findById(Long id)
    {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent())
            return student.get();

            throw new ResourceNotFoundException("Student not found with id " + id);
    }

}
