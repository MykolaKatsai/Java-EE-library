package com.example.library.entitys;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    private String title;
    private String isbn;
    private String author;

    public Book createCopy() {
        return new Book(title, isbn, author);
    }
}
