package com.example.demo.controllers;

import com.example.demo.entitys.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/add")
    public String bookAddForm() {
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
    }
}
