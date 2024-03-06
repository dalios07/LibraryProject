package com.example.demo.entites;

import com.example.demo.Enums.status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private status status;
    @CreatedDate
    private Date registrationDate;
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private Set<Issue> issues = new HashSet<>();
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private Set<BookRequest> requests = new HashSet<>();



}
