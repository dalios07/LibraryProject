package com.example.demo.controllers;

import com.example.demo.dtos.CategoryDto;
import com.example.demo.dtos.IssueDto;
import com.example.demo.entites.Category;
import com.example.demo.entites.Issue;
import com.example.demo.services.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Issue")
@AllArgsConstructor
public class IssueController {


    private final IssueService issueService;
    @GetMapping

    public Page<IssueDto> Getall(Pageable pageable)
    {

        return(issueService.findAll(pageable));

    }
    @GetMapping("/{id}")

    public IssueDto GetById(@PathVariable("id") Long id)
    {

        return(issueService.findById(id));

    }



    @PostMapping

    public Issue Add(@RequestBody IssueDto IssueDto)
    {

        return(issueService.addIssue(IssueDto));

    }
    @PostMapping("Edit")
    public Issue Edit(@RequestBody IssueDto IssueDto)
    {
        return (issueService.EditIssue(IssueDto));
    }
}

