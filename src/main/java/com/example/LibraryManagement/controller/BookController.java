package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.BookService;
import com.example.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService = new BookService();
    @Autowired
    UserService userService;

    @RequestMapping("/books")
    public String getAllBooks(@RequestParam("idFromView") String userId, Model model) {
        model.addAttribute("user", userService.findUserById(userId));
        model.addAttribute("booksList", bookService.getAllBooks());
        return "books";
    }
}
