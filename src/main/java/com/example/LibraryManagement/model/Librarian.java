package com.example.LibraryManagement.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Librarian {

    private String librarianId;
    private String name;
    private String address;
    private int age;
    private String position;
    private double salary;

}
