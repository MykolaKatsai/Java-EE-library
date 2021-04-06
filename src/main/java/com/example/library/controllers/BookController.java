package com.example.library.controllers;

import com.example.library.dto.BookDTO;
import com.example.library.entitys.Book;
import com.example.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @GetMapping("/{isbn}")
    public String getBookPage(@PathVariable String isbn, Model model) {
        Book book = bookService.findById(new BigInteger(isbn));
        BookDTO bookDTO = new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor());
        model.addAttribute("book", bookDTO);
        return "book_page";
    }

    @Autowired
    private void getBookService(BookService bookService) {
        this.bookService = bookService;
    }

/*    @GetMapping("/add")
    public String bookAddForm(ModelMap model) {
        model.put("book", new Book());
        return "create_book";
    }

    @GetMapping
    public String getAllBooks(){
        return "all_books";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){

        System.out.println(book);
        return null;
    }*/
}
