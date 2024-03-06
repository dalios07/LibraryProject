package com.example.demo.mappers;

import com.example.demo.dtos.IssueDto;
import com.example.demo.entites.Issue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IssueMapper {
    IssueDto toIssueDto(Issue issue);
    Issue toIssue(IssueDto issueDto );
}
