package com.example.demo.repositories;

import com.example.demo.entites.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue, Long> {
}
