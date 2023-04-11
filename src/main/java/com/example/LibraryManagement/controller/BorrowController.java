package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.service.BookService;
import com.example.LibraryManagement.service.BorrowService;
import com.example.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService = new BorrowService();
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @RequestMapping("/createBorrow")
        public String createBorrow(@RequestParam("userIdFromView") String userId, @RequestParam("selectedBooks") List<String> selectedBooks) {

        User userThatBorrows = userService.findUserById(userId);
        List<Book> booksToBorrow = new ArrayList<>();
        for(String bookIds : selectedBooks) {
            Book addToBorrows = bookService.findBookById(bookIds);
            booksToBorrow.add(addToBorrows);
        }
        borrowService.makeABorrow(userThatBorrows, booksToBorrow);
        return "users";
    }
}
