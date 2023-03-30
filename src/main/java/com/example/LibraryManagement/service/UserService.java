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

    public HashMap<String,User> getAllUsers() {
        return users;
    }

    public User findUserById(String id) {
        return users.get(id);
    }

    public void deleteUserById(String id) {
        users.remove(id);
    }

    public void updateUserByUser(User userFound) {
        users.put(userFound.getUserId(), userFound);
    }
}

