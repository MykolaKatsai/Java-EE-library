package com.example.library.services.impl;

import com.example.library.entitys.Book;
import com.example.library.repositories.BookRepository;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.getBooksByTitle(title);
    }

    @Override
    public List<Book> searchBook(Predicate<Book> predicate) {
        return bookRepository.getAllBooks().stream().
                filter(predicate).
                collect(Collectors.toList());
    }


    @Autowired
    private void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
