package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService = new BookService();

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("booksList", bookService.getAllBooks());
        return "books";
    }
}
