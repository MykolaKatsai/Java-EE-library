package com.example.library.repositories;

import com.example.library.entitys.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, BigInteger> {
    Book findByIsbn(BigInteger isbn);

    List<Book> findByTitle(String title);
}
