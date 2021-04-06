package com.example.library.services.impl;

import com.example.library.entitys.Book;
import com.example.library.repositories.BookJpaRepository;
import com.example.library.repositories.BookRepository;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookJpaRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(BigInteger isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> searchBook(Predicate<Book> predicate) {
        return bookRepository.findAll().stream().
                filter(predicate).
                collect(Collectors.toList());
    }


    @Autowired
    private void setBookRepository(BookJpaRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
