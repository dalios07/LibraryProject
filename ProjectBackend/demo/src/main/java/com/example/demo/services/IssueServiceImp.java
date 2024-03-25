package com.example.demo.services;

import com.example.demo.Exceptions.BookNotAvailbaleException;
import com.example.demo.Exceptions.ResourceNotFoundException;
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
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class IssueServiceImp  implements IssueService{

    private final IssueRepo issueRepository;
    private final IssueMapper issueMapper;
    private final BookService bookService;
    private final UserService userService;
    private final BookMapper bookMapper;

    @Override
    public Page<IssueDto> findAll(Pageable pageable) {
        Page<Issue> issues = issueRepository.findAll(pageable);

        return issues.map(issue ->{
            IssueDto issueDto= issueMapper.toIssueDto(issue);
            issueDto.setBookName(issue.getBook().getName());
            issueDto.setIsbn(issue.getBook().getIsbn());
            issueDto.setStudentName(issue.getUser().getName());
            issueDto.setStudentId(issue.getUser().getId());
            return (issueDto);
        });
    }
    @Override
    public  IssueDto findById(Long id)
    {
        Optional<Issue> issue=issueRepository.findById(id);
        if(issue.isPresent())
        {
            Issue issue0=issue.get();
            IssueDto issueDto= issueMapper.toIssueDto(issue0);
            issueDto.setBookName(issue0.getBook().getName());
            issueDto.setIsbn(issue0.getBook().getIsbn());
            issueDto.setStudentName(issue0.getUser().getName());
            issueDto.setStudentId(issue0.getUser().getId());
            return issueDto;
        }


        throw new ResourceNotFoundException("Issue not found with id " + id);

    }

    @Override
    public Issue addIssue(IssueDto IssueDto) {
        Issue issue=issueMapper.toIssue(IssueDto);
        User user = userService.findById(IssueDto.getStudentId());
        Book book=bookService.findByIsbn(IssueDto.getIsbn());
        issue.setBook(book);
        issue.setUser(user);
        if(Objects.equals(book.getIssuedCopies(), book.getTotalCopies()))
            throw new BookNotAvailbaleException("This book is not available now"+book.getIssuedCopies());


        bookService.EditBook(1,book);

        return (issueRepository.save(issue));
    }

    @Override
    public Issue EditIssue(IssueDto IssueDto)
    {
        Issue issue=issueMapper.toIssue(IssueDto);
        User user = userService.findById(IssueDto.getStudentId());
        Book book=bookService.findByIsbn(IssueDto.getIsbn());
        issue.setBook(book);
        issue.setUser(user);
        bookService.EditBook(-1,book);
        return (issueRepository.save(issue));
    }
}
