package com.example.demo.services;

import com.example.demo.Exceptions.BookNotAvailbaleException;
import com.example.demo.dtos.BookDto;
import com.example.demo.dtos.IssueDto;
import com.example.demo.entites.*;
import com.example.demo.mappers.BookMapper;
import com.example.demo.mappers.IssueMapper;
import com.example.demo.repositories.IssueRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class IssueServiceImp  implements IssueService{

    private final IssueRepo issueRepository;
    private final IssueMapper issueMapper;
    private final BookService bookService;
    private final StudentService studentService;
    private final BookMapper bookMapper;

    @Override
    public Page<IssueDto> findAll(Pageable pageable) {
        Page<Issue> issues = issueRepository.findAll(pageable);

        return issues.map(issue ->{
            IssueDto issueDto= issueMapper.toIssueDto(issue);
            issueDto.setBookName(issue.getBook().getName());
            issueDto.setIsbn(issue.getBook().getIsbn());
            issueDto.setStudentName(issue.getStudent().getName());
            issueDto.setStudentId(issue.getStudent().getId());
            return (issueDto);
        });
    }
    @Override
    public Issue addIssue(IssueDto IssueDto) {
        Issue issue=issueMapper.toIssue(IssueDto);
        Student student=studentService.findById(IssueDto.getStudentId());
        Book book=bookService.findByIsbn(IssueDto.getIsbn());
        issue.setBook(book);
        issue.setStudent(student);
        if(Objects.equals(book.getIssuedCopies(), book.getTotalCopies()))
            throw new BookNotAvailbaleException("This book is not available now"+book.getIssuedCopies());


        bookService.EditBook(1,book);

        return (issueRepository.save(issue));
    }

    @Override
    public Issue EditIssue(IssueDto IssueDto)
    {
        Issue issue=issueMapper.toIssue(IssueDto);
        Student student=studentService.findById(IssueDto.getStudentId());
        Book book=bookService.findByIsbn(IssueDto.getIsbn());
        issue.setBook(book);
        issue.setStudent(student);
        bookService.EditBook(-1,book);
        return (issueRepository.save(issue));
    }
}
