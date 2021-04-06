package com.example.library.repositories.impl;

import com.example.library.entitys.Book;
import com.example.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository("BookRepositoryPersistence")
@RequiredArgsConstructor
public class BookRepositoryPersistenceImpl implements BookRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Book saveBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        List<Book> books = entityManager.createQuery("SELECT b FROM books b", Book.class)
                .getResultList();
        return books;
    }

    @Override
    @Transactional
    public List<Book> getBooksByTitle(String title) {
        List<Book> books = entityManager.createQuery("SELECT b FROM books b WHERE b.title LIKE ?1", Book.class)
                .setParameter(1, "'%" + title + "%'")
                .getResultList();
        return books;
    }

    @Override
    @Transactional
    public Book getBook(BigInteger isbn) {
        return entityManager.find(Book.class, isbn);
    }
}
