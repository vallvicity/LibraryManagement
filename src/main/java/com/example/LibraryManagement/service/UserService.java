package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {
    public static HashMap<String, User> users = new HashMap<>();

    public static void populateFakeUsers(int fakeUsersNumber) {
        Utils.populateFakeUsers(fakeUsersNumber, users);
    }
}

