package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.Librarian;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LibrarianService {

    public static HashMap<String, Librarian> librarians = new HashMap<>();

    public HashMap<String,Librarian> getAllLibrarians() {
        return librarians;
    }

    public Librarian findLibrarianById(String librarianId) {
       return librarians.get(librarianId);
    }

    public void deleteLibrarianById(String librarianId) {
        librarians.remove(librarianId);
    }
}
