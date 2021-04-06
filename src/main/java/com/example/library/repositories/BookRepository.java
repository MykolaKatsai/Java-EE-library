package com.example.library.repositories;

import com.example.library.entitys.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookRepository {

    Book saveBook(Book book);

    List<Book> getAllBooks();

    List<Book> getBooksByTitle(String title);

    Book getBook(BigInteger isbn);
}
