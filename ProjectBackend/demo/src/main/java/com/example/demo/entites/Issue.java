package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "issues")
@EntityListeners(AuditingEntityListener.class)
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int fine;
    @CreatedDate
    private Date CreationDate;
    private Date returnDate;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
