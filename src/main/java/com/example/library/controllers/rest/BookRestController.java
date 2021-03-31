package com.example.library.controllers.rest;

import com.example.library.dto.BookDTO;
import com.example.library.entitys.Book;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    private BookService bookService;

    @PostMapping("/book/add")
    public ResponseEntity<String> addBookRest(@RequestBody BookDTO bookDTO) {

        Book book = new Book(bookDTO.getTitle(), bookDTO.getIsbn(), bookDTO.getAuthor());
        Book addedBook = bookService.addBook(book);

        if (addedBook == null) {
            throw new RuntimeException();
        }

        return ResponseEntity.ok("Book added successfully!");
    }

    @GetMapping("/book/all")
    public List<Book> getAllBooksRest() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/get")
    public List<Book> getBookByTitleRest(@RequestParam("title") String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping("/book/search")
    public List<Book> searchBook(@RequestParam("title") String title,
                                 @RequestParam("isbn") String isbn,
                                 @RequestParam("author") String author) {

        Predicate<Book> predicate = x -> true;
        if (!StringUtils.isEmpty(title)) {
            predicate = predicate.and(b -> title.equals(b.getTitle()));
        }
        if (!StringUtils.isEmpty(isbn)) {
            predicate = predicate.and(b -> isbn.equals(b.getIsbn()));
        }
        if (!StringUtils.isEmpty(author)) {
            predicate = predicate.and(b -> author.equals(b.getAuthor()));
        }

        return bookService.searchBook(predicate);
    }


    @Autowired
    private void getBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
