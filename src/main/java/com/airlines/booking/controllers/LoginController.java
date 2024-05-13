package com.airlines.booking.controllers;

import com.airlines.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/Login")
    public String Login(Model model) {
        model.addAttribute("title", "Login");
        return "Login";
    }
}