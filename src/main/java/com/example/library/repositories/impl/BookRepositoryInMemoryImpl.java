package com.example.library.repositories.impl;

import com.example.library.entitys.Book;
import com.example.library.repositories.BookRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("BookRepositoryInMemory")
public class BookRepositoryInMemoryImpl implements BookRepository {

    private static List<Book> booksDB = new ArrayList<>(); //imitated db

    @Override
    public Book saveBook(Book book) {
        booksDB.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return booksDB.stream()
                .map(Book::createCopy)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return booksDB.stream()
                .filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    @Deprecated
    public Book getBook(BigInteger isbn) {
        return null;
    }
}
