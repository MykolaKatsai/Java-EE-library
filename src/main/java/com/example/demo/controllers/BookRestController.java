package com.example.demo.controllers;

import com.example.demo.entitys.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    private BookService bookService;

    @PostMapping("/book/add")
    public ResponseEntity<String> addBookRest(@RequestBody Book book) {
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

    @Autowired
    private void getBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
