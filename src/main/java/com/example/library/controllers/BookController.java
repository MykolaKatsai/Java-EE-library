package com.example.library.controllers;

import com.example.library.entitys.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/add")
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
    }
}
