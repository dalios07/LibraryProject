package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int totalCopies;
    private int issuedCopies;
    @Column(unique = true)
    private String isbn;
    private Double price;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private Set<Issue> issues = new HashSet<>();
    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private Set<BookRequest> requests = new HashSet<>();




}
