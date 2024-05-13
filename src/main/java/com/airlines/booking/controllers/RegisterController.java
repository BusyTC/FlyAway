package com.airlines.booking.controllers;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/Register")
    public String Register(Model model) {
        model.addAttribute("title", "Main page");
        return "Register";
    }
    @PostMapping("/Register")
    public String RegisterSend(@RequestParam String first_name, @RequestParam String last_name,
                               @RequestParam String email, @RequestParam String password, Model model) {
        User user = new User(first_name, last_name, email, password);
        userRepository.save(user);
        return "redirect:/";
    }
}