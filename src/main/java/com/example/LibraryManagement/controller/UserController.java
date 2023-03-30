package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.User;
import com.example.LibraryManagement.service.UserService;
import com.example.LibraryManagement.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String getAllUsers(Model model) {

        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @RequestMapping("/createFakeUsers")
    public String createUsers(@RequestParam("qty") int fakeUsersNumber) {

        Utils.populateFakeUsers(fakeUsersNumber, userService.getAllUsers());

        return "redirect:users";
    }

    @RequestMapping("/filledUserForm")
    public String returnUserForm(@RequestParam("idFromView") String id, Model model) {
        User userFound = userService.findUserById(id);
        model.addAttribute("userFromController", userFound);
        return "filledUserForm";
    }

    @RequestMapping("/deleteUser")
    public String deleteUserById(@RequestParam("idFromView") String id) {

        userService.deleteUserById(id);
        return "redirect:users";
    }

    @RequestMapping("/getUserFormToUpdate")
    public String bringFormToUpdate(@RequestParam("idFromView") String id, Model model) {
        User userFound = userService.findUserById(id);

        model.addAttribute("userFromController", userFound);
        return "userFormToUpdate";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("idFromView") String id) {

        User userFound = userService.findUserById(id);

        if(userFound == null) {

        }
        return "";
    }
}
