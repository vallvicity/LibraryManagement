package com.example.LibraryManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    private String borrowId;
    private Date borrowDate;
    private Date dueDate;
    private String borrowStatus;
    private List<Book> borrowedBooks;
    private User user;


}
