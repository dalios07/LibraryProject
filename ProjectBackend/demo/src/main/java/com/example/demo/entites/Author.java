package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "authors")
@EntityListeners(AuditingEntityListener.class)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date CreationDate;
    @LastModifiedDate
    private Date UpdatingDate;
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();
}
