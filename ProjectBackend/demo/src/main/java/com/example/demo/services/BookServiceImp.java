package com.example.demo.services;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dtos.BookDto;
import com.example.demo.entites.Author;
import com.example.demo.entites.Book;
import com.example.demo.entites.Category;
import com.example.demo.mappers.BookMapper;
import com.example.demo.repositories.BookRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class BookServiceImp implements BookService {


    private final BookRepo bookRepository;
    private final BookMapper bookMapper;
    private final CategoryService categoryService ;
    private final AuthorService authorService ;

    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);

        return books.map(book ->{
            BookDto bookDto= bookMapper.toBookDto(book);
            bookDto.setCategoryName(book.getCategory().getName());
            bookDto.setAuthorName(book.getAuthor().getName());
            return (bookDto);
        });
    }
    @Override
    public BookDto findById(Long id)
    {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent())
        {
            BookDto bookDto= bookMapper.toBookDto(book.get());
            bookDto.setCategoryName(book.get().getCategory().getName());
            bookDto.setAuthorName(book.get().getAuthor().getName());
            return  bookDto ;
        }


        throw new ResourceNotFoundException("Book not found with id " + id);

    }
    @Override
    public Book findByIsbn(String isbn)
    {
        if (!bookRepository.existsByIsbn(isbn)) {
            throw new ResourceNotFoundException("Book not found with isbn " + isbn);}
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Page<BookDto> searchBooks(String name, Pageable pageable)
    {
        Page<Book> books=bookRepository.findByNameContainingIgnoreCase(name, pageable);
        return books.map(book -> bookMapper.toBookDto(book));

    }
    @Override
    public Book addBook(BookDto BookDto) {
        Book book=bookMapper.toBook(BookDto);
        Category category=categoryService.findByNameAndStatus(BookDto.getCategoryName());
        Author author=authorService.findByName(BookDto.getAuthorName());
        book.setCategory(category);
        book.setAuthor(author);

        return (bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public void EditBook(int nb,Book book)
    {
        book.setIssuedCopies(book.getIssuedCopies()+nb);
        bookRepository.save(book);
    }


}

