package com.example.demo.services;

import com.example.demo.dtos.IssueDto;
import com.example.demo.entites.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    Page<IssueDto> findAll(Pageable pageable);

    Issue addIssue(IssueDto IssueDto);

    Issue EditIssue(IssueDto IssueDto);
}
