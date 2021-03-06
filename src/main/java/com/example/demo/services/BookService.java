package com.example.demo.services;

import com.example.demo.entitys.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    List<Book> getAllBooks();

    List<Book> findBooksByTitle(String name);
}
