package com.example.demo.services.impl;

import com.example.demo.entitys.Book;
import com.example.demo.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static List<Book> booksDB = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        boolean isAdded = booksDB.add(book);
        return isAdded ? book : null;
    }

    @Override
    public List<Book> getAllBooks() {
        return booksDB; // TODO: return copy
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return booksDB.stream()
                .filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList());
    }
}
