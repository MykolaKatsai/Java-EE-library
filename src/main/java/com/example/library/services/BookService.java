package com.example.library.services;

import com.example.library.entitys.Book;

import java.util.List;
import java.util.function.Predicate;

public interface BookService {
    Book addBook(Book book);

    List<Book> getAllBooks();

    List<Book> findBooksByTitle(String name);

    List<Book> searchBook(Predicate<Book> predicate);
}
