package com.example.LibraryManagement.utils;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.Librarian;
import com.example.LibraryManagement.model.User;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.UUID;


public class Utils {

    public static String createUUID() {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return id;
    }

    public static String createISBN() {

        UUID uuid = UUID.randomUUID();
        String isbn = uuid.toString().toUpperCase().replace("-", "");

        return isbn;
    }

    public static void populateFakeUsers(int number, HashMap<String, User> users) {

        Faker faker = new Faker();
        User newUser;

        for(int i = 0; i < number; i++) {

            newUser = new User();

            String name = faker.funnyName().name();
            newUser.setName(name);

            String userId = Utils.createUUID();
            newUser.setUserId(userId);

            int userAge = faker.number().numberBetween(12,100);
            newUser.setAge(userAge);

            String userAddress = faker.address().fullAddress();
            newUser.setAddress(userAddress);

            users.put(userId, newUser);
        }

    }

    public static void createFakeLibrarian(int number, HashMap<String, Librarian> librarians){

        Faker faker = new Faker();
        Librarian newLibrarian;

        for (int i = 0; i < number; i++) {

            newLibrarian = new Librarian();

            String name = faker.funnyName().name();
            newLibrarian.setName(name);

            String librarianId = Utils.createUUID();
            newLibrarian.setLibrarianId(librarianId);

            String librarianAddress = faker.address().cityName();
            newLibrarian.setAddress(librarianAddress);

            int age = faker.number().numberBetween(18, 65);
            newLibrarian.setAge(age);

            String position = "Worker";
            newLibrarian.setPosition(position);

            double salary = 100.000;
            newLibrarian.setSalary(salary);

            librarians.put(librarianId, newLibrarian);

        }
    }

    public static void createFakeBooks(int number, HashMap<String, Book> books) {

        Faker faker = new Faker();
        Book newBook;

        for (int i = 0; i < number; i++) {
            newBook = new Book();

            String bookId = createUUID();
            newBook.setBookId(bookId);

            String title = faker.book().title();
            newBook.setTitle(title);

            String author = faker.book().author();
            newBook.setAuthor(author);

            int numPages = faker.number().numberBetween(100, 999);
            newBook.setPages(numPages);

            int publishedYear = faker.number().numberBetween(1400, 2023);
            newBook.setPublishedYear(publishedYear);

            String isbn = createISBN();
            newBook.setIsbn(isbn);

            books.put(bookId, newBook);
        }
    }

}
