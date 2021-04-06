package com.example.library.entitys;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity(name = "books")
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    @Id
    @NotNull
    private BigInteger isbn;

    private String title;

    private String author;

    public Book() {
    }

    public Book(BigInteger isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Book createCopy() {
        return new Book(isbn, title, author);
    }
}
