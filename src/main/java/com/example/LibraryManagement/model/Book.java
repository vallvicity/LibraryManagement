package com.example.LibraryManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    private String bookId;
    private String title;
    private String author;
    private int pages;
    private int publishedYear;
    private String isbn;
}
