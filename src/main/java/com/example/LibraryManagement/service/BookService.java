package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookService {

    public static HashMap<String, Book> books = new HashMap<>();

    static {
        Utils.createFakeBooks(100, books);
    }

    public HashMap<String, Book> getAllBooks(){
        return books;
    }

    public Book findBookById(String id) {
        return books.getOrDefault(id, null);
    }
}
