package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.Borrow;
import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BorrowService {

    public static HashMap<String, Borrow> borrows = new HashMap<>();

    public static Borrow getBorrowById(String id) {
        return borrows.getOrDefault(id, null);
    }

    public static HashMap<String, Borrow> getAllBorrows() {
        return borrows;
    }

    public void makeABorrow(User user, List<Book> booksToBorrow) {

        //Establish current date for borrow
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date();
        calendar.setTime(currentDate);

        //Calculate last day to return the book(!5 days from current Date)
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        Date dueDate = calendar.getTime();

        //Create Borrow & setters
        Borrow newBorrow = new Borrow();

        newBorrow.setBorrowDate(currentDate);
        newBorrow.setBorrowId(Utils.createUUID());
        newBorrow.setUser(user);
        newBorrow.setBorrowedBooks(booksToBorrow);
        newBorrow.setBorrowStatus("PROGRESS");
        newBorrow.setDueDate(dueDate);

        borrows.put(newBorrow.getBorrowId(), newBorrow);
    }
}
