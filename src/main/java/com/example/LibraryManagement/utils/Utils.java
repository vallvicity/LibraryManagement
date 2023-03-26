package com.example.LibraryManagement.utils;

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

    public static HashMap<String, User> populateFakeUsers(int number, HashMap<String, User> users) {

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

        return users;
    }

}
