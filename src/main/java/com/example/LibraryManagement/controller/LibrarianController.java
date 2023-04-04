package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Librarian;
import com.example.LibraryManagement.service.LibrarianService;
import com.example.LibraryManagement.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LibrarianController {

    @Autowired
    LibrarianService librarianService = new LibrarianService();

    @RequestMapping("/librarians")
    public String getAllLibrarians(Model model) {

        model.addAttribute("librarians", librarianService.getAllLibrarians());
        return "librarians";
    }

    @RequestMapping("/createLibrarian")
    public String createFakeLibrarian(@RequestParam("qty") int number, Model model){
        Utils.createFakeLibrarian(number, librarianService.getAllLibrarians());
        return "redirect:librarians";
    }

    @RequestMapping("/deleteLibrarian")
    public String deleteLibrarianById(@RequestParam("idFromView") String librarianId) {
        librarianService.deleteLibrarianById(librarianId);
        return "redirect:librarians";



    }

}
